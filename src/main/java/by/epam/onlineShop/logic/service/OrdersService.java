package by.epam.onlineShop.logic.service;

import by.epam.onlineShop.dao.UserDao.UserDaoImpl;
import by.epam.onlineShop.dao.helper.DaoHelper;
import by.epam.onlineShop.dao.helper.DaoHelperFactory;
import by.epam.onlineShop.dao.orderDao.OrderDaoImpl;
import by.epam.onlineShop.dao.productDao.ProductDaoImpl;
import by.epam.onlineShop.dao.promotionDao.PromotionDaoImpl;
import by.epam.onlineShop.dao.userInformationDao.UserInformationDaoImpl;
import by.epam.onlineShop.dao.userOrdersDao.UserOrdersDaoImpl;
import by.epam.onlineShop.entity.*;
import by.epam.onlineShop.exeptions.ConnectionException;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.exeptions.ServiceException;

import java.util.List;
import java.util.Optional;

public class OrdersService extends AbstractService {
    public OrdersService(DaoHelperFactory daoHelperFactory) {
        super(daoHelperFactory);
    }

    public List<Order> getAllOrdersByUserId(long userId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {

            OrderDaoImpl dao = daoHelper.createOrderDao();
            List<Order> result = null;
            result = dao.getOrders(userId);
            return result;
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<UserOrder> getAllUserOrdersByStatus(String status) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {

            UserOrdersDaoImpl dao = daoHelper.createUserOrdersDao();
            List<UserOrder> result = null;
            result = dao.getUserOrdersByStatus(status);
            return result;
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public Optional<UserOrder> getUserOrderById(long userOrderId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {

            UserOrdersDaoImpl dao = daoHelper.createUserOrdersDao();
            Optional<UserOrder> result;
            result = dao.getById(userOrderId);
            return result;
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<Order> getAllOrdersByUserOrderId(long userOrderId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {

            OrderDaoImpl dao = daoHelper.createOrderDao();
            List<Order> result = null;
            result = dao.getOrdersByUserOrder(userOrderId);
            return result;
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public Optional<Product> getProductById(long productId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {

            ProductDaoImpl dao = daoHelper.createProductDao();
            Optional<Product> result;
            result = dao.getById(productId);
            return result;
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public Optional<User> getUserById(long userId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {

            UserDaoImpl dao = daoHelper.createUserDao();
            Optional<User> result;
            result = dao.getById(userId);
            return result;
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public Optional<UserInformation> getUserInformationById(long userInformationId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {

            UserInformationDaoImpl dao = daoHelper.createUserInformationDao();
            Optional<UserInformation> result;
            result = dao.getById(userInformationId);
            return result;
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
