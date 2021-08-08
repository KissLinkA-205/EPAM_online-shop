package by.epam.onlineShop.service.impl;

import by.epam.onlineShop.dao.DaoFactory;
import by.epam.onlineShop.dao.OrderDao;
import by.epam.onlineShop.dao.ProductDao;
import by.epam.onlineShop.dao.impl.PromotionDaoImpl;
import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.entity.Product;
import by.epam.onlineShop.entity.Promotion;
import by.epam.onlineShop.entity.UserOrder;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.service.OrderService;
import by.epam.onlineShop.service.PromotionService;
import by.epam.onlineShop.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<Order> retrieveOrdersByUserWithoutUserOrder(long userId) throws ServiceException {
        try {
            OrderDao orderDao = DaoFactory.getInstance().getOrderDao();
            List<Order> result = null;
            result = orderDao.findByUserWithoutUserOrder(userId);
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve orders by user id without user order!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Order> retrieveOrdersByUser(long userId) throws ServiceException {
        try {
            OrderDao orderDao = DaoFactory.getInstance().getOrderDao();
            List<Order> result = null;
            result = orderDao.findByUser(userId);
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve orders by user id without user order!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Order> retrieveOrdersByUserOrder(long userOrderId) throws ServiceException {
        try {
            OrderDao orderDao = DaoFactory.getInstance().getOrderDao();
            List<Order> result = null;
            result = orderDao.findByUserOrder(userOrderId);
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve orders by user order!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean removeOrderById(long orderId) throws ServiceException {
        try {
            OrderDao orderDao = DaoFactory.getInstance().getOrderDao();
            Optional<Order> order = orderDao.findById(orderId);
            if (!order.isPresent()) {
                return false;
            }
            orderDao.removeById(orderId);
            return true;
        } catch (DaoException e) {
            logger.error("Unable to remove order by id!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean addNewOrder(long userId, long productId, int number) throws ServiceException {
        try {
            OrderDao orderDao = DaoFactory.getInstance().getOrderDao();
            List<Order> existOrders = orderDao.findByUserAndProductWithoutUserOrder(userId, productId);
            if (!(existOrders.size() == 0)) {
                return false;
            }

            Order order = buildOrder(userId, productId, number);
            orderDao.save(order);
            return true;
        } catch (DaoException e) {
            logger.error("Unable to add order!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public double calculateTotalCost(List<Order> orders) throws ServiceException {
        double totalCost = 0;
        try {
            ProductDao productDao = DaoFactory.getInstance().getProductDao();
            for (Order order : orders) {
                long productId = order.getProductId();

                Optional<Product> product = productDao.findById(productId);
                if (product.isPresent()) {
                    if (product.get().getPromotionId() != 0) {
                        PromotionDaoImpl promotionDao = DaoFactory.getInstance().getPromotionDao();
                        Optional<Promotion> promotion = promotionDao.findById(product.get().getPromotionId());

                        if (promotion.isPresent()) {
                            PromotionService promotionService = ServiceFactory.getInstance().getPromotionService();
                            double newPrice = promotionService.calculateNewPrice(product.get().getPrice(), promotion.get().getDiscount());
                            double scale = Math.pow(10, 2);
                            newPrice = Math.ceil(newPrice * scale) / scale;
                            product.get().setPrice(newPrice);
                        }
                    }
                    totalCost += product.get().getPrice() * order.getNumber();
                }
            }
            return totalCost;
        } catch (DaoException e) {
            logger.error("Unable to calculate total cost of orders!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Order> getOrdersFromUserOrders(List<UserOrder> userOrders) throws ServiceException {
        List<Order> orders = new LinkedList<>();

        for (UserOrder userOrder : userOrders) {
            List<Order> order = retrieveOrdersByUserOrder(userOrder.getId());
            if (!order.isEmpty()) {
                orders.addAll(order);
            }
        }

        return orders;
    }

    private Order buildOrder(long userId, long productId, int number) {
        Order order = new Order();
        order.setUserId(userId);
        order.setProductId(productId);
        order.setNumber(number);
        return order;
    }
}
