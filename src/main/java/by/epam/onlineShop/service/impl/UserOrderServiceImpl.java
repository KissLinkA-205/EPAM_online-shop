package by.epam.onlineShop.service.impl;

import by.epam.onlineShop.dao.DaoFactory;
import by.epam.onlineShop.dao.OrderDao;
import by.epam.onlineShop.dao.UserOrderDao;
import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.entity.UserOrder;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.service.BankCardService;
import by.epam.onlineShop.service.ServiceFactory;
import by.epam.onlineShop.service.UserOrderService;
import by.epam.onlineShop.service.validator.Validator;
import by.epam.onlineShop.service.validator.ValidatorFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserOrderServiceImpl implements UserOrderService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public Optional<UserOrder> retrieveUserOrderById(long userOrderId) throws ServiceException {
        try {
            UserOrderDao userOrderDao = DaoFactory.getInstance().getUserOrderDao();
            Optional<UserOrder> result;
            result = userOrderDao.findById(userOrderId);
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve user order by id!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<UserOrder> retrieveUserOrderByStatus(String status) throws ServiceException {
        try {
            UserOrderDao userOrderDao = DaoFactory.getInstance().getUserOrderDao();
            List<UserOrder> result = null;
            result = userOrderDao.findByStatus(status);
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve promotions!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateStatusAtUserOrderById(long userOrderId, String status) throws ServiceException {
        try {
            UserOrderDao userOrderDao = DaoFactory.getInstance().getUserOrderDao();
            Optional<UserOrder> userOrder = userOrderDao.findById(userOrderId);
            if (!userOrder.isPresent()) {
                return false;
            }
            userOrderDao.updateStatusById(userOrderId, status);
            return true;
        } catch (DaoException e) {
            logger.error("Unable to update user order status!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean addNewUserOrder(List<Order> orders, String address, String deliveryDateString, String cardholderName,
                                   String cvvString, String cardNumberString, String monthString, String yearString, double totalPrice) throws ServiceException {
        try {
            if (address == null || deliveryDateString == null || orders.size() < 1 || cardholderName == null ||
                    cvvString == null || cardNumberString == null || monthString == null || yearString == null) {
                return false;
            }

            Date deliveryDate = new SimpleDateFormat("yyyy-MM-dd").parse(deliveryDateString);
            Date currentDate = new Date();
            if (!isDateValid(deliveryDate, currentDate)) {
                return false;
            }

            Validator cardNumberValidator = ValidatorFactory.getInstance().getCardNumberValidator();
            Validator cvvValidator = ValidatorFactory.getInstance().getCvvValidator();
            Validator monthValidator = ValidatorFactory.getInstance().getMonthValidator();
            Validator yearValidator = ValidatorFactory.getInstance().getYearValidator();

            if (!(cardNumberValidator.isValid(cardNumberString) && cvvValidator.isValid(cvvString)
                    && monthValidator.isValid(monthString) && yearValidator.isValid(yearString))) {
                return false;
            }

            long cardNumber = Long.parseLong(cardNumberString);
            int cvv = Integer.parseInt(cvvString);
            int month = Integer.parseInt(monthString);
            int year = Integer.parseInt(yearString);
            if (!isCardDateValid(month, year)) {
                return false;
            }

            BankCardService bankCardService = ServiceFactory.getInstance().getBankCardService();
            if (!bankCardService.makePayment(cardNumber, month, year, cvv, totalPrice)) {
                return false;
            }

            UserOrder userOrder = buildUserOrder(address, deliveryDate, currentDate, "ожидается");
            UserOrderDao userOrderDao = DaoFactory.getInstance().getUserOrderDao();
            long userOrderId = userOrderDao.save(userOrder);

            OrderDao orderDao = DaoFactory.getInstance().getOrderDao();
            for (Order order : orders) {
                orderDao.updateUserOrder(order.getId(), userOrderId);
            }
            return true;
        } catch (ParseException | DaoException e) {
            logger.error("Unable to add new user order!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<UserOrder> getUserOrdersFromOrders(List<Order> orders) throws ServiceException {
        List<UserOrder> userOrders = new LinkedList<>();

        for (Order order : orders) {
            Optional<UserOrder> userOrder = retrieveUserOrderById(order.getUserOrderId());
            if (userOrder.isPresent()) {
                boolean checkIfOrderExistFlag = false;
                for (UserOrder value : userOrders) {
                    if (value.getId() == userOrder.get().getId()) {
                        checkIfOrderExistFlag = true;
                    }
                }
                if (!checkIfOrderExistFlag) {
                    userOrders.add(userOrder.get());
                }
            }
        }

        return userOrders;
    }

    private boolean isDateValid(Date deliveryDate, Date currentDate) {
        return deliveryDate.compareTo(currentDate) > 0;
    }

    private boolean isCardDateValid(int month, int year) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currentMonth = cal.get(Calendar.MONTH);
        int currentYear = cal.get(Calendar.YEAR);

        if (year < currentYear) return false;
        if (year == currentYear) {
            if (month <= currentMonth) {
                return false;
            }
        }
        return true;
    }

    private UserOrder buildUserOrder(String address, Date deliveryDate, Date orderDate, String status) {
        UserOrder userOrder = new UserOrder();
        userOrder.setAddress(address);
        userOrder.setOrderDate(orderDate);
        userOrder.setDeliveryDate(deliveryDate);
        userOrder.setStatus(status);
        return userOrder;
    }
}
