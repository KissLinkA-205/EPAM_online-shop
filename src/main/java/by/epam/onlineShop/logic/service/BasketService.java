package by.epam.onlineShop.logic.service;

import by.epam.onlineShop.dao.helper.DaoHelper;
import by.epam.onlineShop.dao.helper.DaoHelperFactory;
import by.epam.onlineShop.dao.orderDao.OrderDaoImpl;
import by.epam.onlineShop.dao.productDao.ProductDaoImpl;
import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.entity.Product;
import by.epam.onlineShop.exeptions.ConnectionException;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.exeptions.ServiceException;

import java.util.List;
import java.util.Optional;

public class BasketService extends AbstractService {
    public BasketService(DaoHelperFactory daoHelperFactory) {
        super(daoHelperFactory);
    }

    public List<Order> getAllOrdersByUserId(long userId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {

            OrderDaoImpl dao = daoHelper.createOrderDao();
            List<Order> result = null;
            result = dao.getOrdersWithoutUserOrder(userId);
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
}
