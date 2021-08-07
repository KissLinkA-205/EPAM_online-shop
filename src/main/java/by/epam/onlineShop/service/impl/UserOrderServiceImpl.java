package by.epam.onlineShop.service.impl;

import by.epam.onlineShop.dao.DaoFactory;
import by.epam.onlineShop.dao.UserOrderDao;
import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.entity.UserOrder;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.service.UserOrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public boolean addNewUserOrder(List<Order> orders, String address, String deliveryDateString) throws ServiceException {
        try {
            UserOrderDao userOrderDao = DaoFactory.getInstance().getUserOrderDao();
            if (address == null || deliveryDateString == null || orders.size() < 1) {
                return false;
            }

            Date deliveryDate = new SimpleDateFormat("yyyy-MM-dd").parse(deliveryDateString);
            Date currentDate = new Date();
            if (!isDateValid(deliveryDate, currentDate)) {
                return false;
            }

            UserOrder userOrder = buildUserOrder(address, deliveryDate, currentDate, "expected");
            userOrderDao.save(userOrder);
            return true;
        } catch (DaoException | ParseException e) {
            logger.error("Unable to update user order status!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    private boolean isDateValid(Date deliveryDate, Date currentDate) {
        return deliveryDate.compareTo(currentDate) > 0;
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
