package by.epam.onlineShop.dao.helper;

import by.epam.onlineShop.connection.ConnectionPool;
import by.epam.onlineShop.connection.ProxyConnection;
import by.epam.onlineShop.dao.UserDao.UserDaoImpl;
import by.epam.onlineShop.dao.catalogDao.CategoryDaoImpl;
import by.epam.onlineShop.dao.promotionDao.PromotionDaoImpl;
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

    @Override
    public void close() throws ConnectionException {
        connection.close();
    }
}
