package by.epam.onlineShop.dao.helper;

import by.epam.onlineShop.connection.ConnectionPool;
import by.epam.onlineShop.connection.ProxyConnection;
import by.epam.onlineShop.dao.UserDao.UserDaoImpl;
import by.epam.onlineShop.dao.catalogDao.CategoryDaoImpl;
import by.epam.onlineShop.dao.orderDao.OrderDaoImpl;
import by.epam.onlineShop.dao.productDao.ProductDaoImpl;
import by.epam.onlineShop.dao.promotionDao.PromotionDaoImpl;
import by.epam.onlineShop.dao.roleDao.RoleDaoImpl;
import by.epam.onlineShop.dao.userInformationDao.UserInformationDaoImpl;
import by.epam.onlineShop.dao.userOrdersDao.UserOrdersDaoImpl;
import by.epam.onlineShop.entity.UserOrder;
import by.epam.onlineShop.exeptions.ConnectionException;

public class DaoHelper implements AutoCloseable {
    private ProxyConnection connection;

    public DaoHelper(ConnectionPool pool) {
        this.connection = pool.getConnection();
    }

    public PromotionDaoImpl createPromotionDao() {
        return new PromotionDaoImpl(connection);
    }

    public UserDaoImpl createUserDao() {
        return new UserDaoImpl(connection);
    }

    public CategoryDaoImpl createCategoryDao() {
        return new CategoryDaoImpl(connection);
    }

    public OrderDaoImpl createOrderDao() {
        return new OrderDaoImpl(connection);
    }

    public UserOrdersDaoImpl createUserOrdersDao() {
        return new UserOrdersDaoImpl(connection);
    }

    public ProductDaoImpl createProductDao() {
        return new ProductDaoImpl(connection);
    }

    public UserInformationDaoImpl createUserInformationDao() {
        return new UserInformationDaoImpl(connection);
    }

    public RoleDaoImpl createRoleDao() {
        return new RoleDaoImpl(connection);
    }

    @Override
    public void close() throws ConnectionException {
        connection.close();
    }
}
