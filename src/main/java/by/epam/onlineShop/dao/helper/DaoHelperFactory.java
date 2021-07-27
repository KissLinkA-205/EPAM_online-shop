package by.epam.onlineShop.dao.helper;

import by.epam.onlineShop.connection.ConnectionPool;
import by.epam.onlineShop.exeptions.ConnectionException;

public class DaoHelperFactory {
    public DaoHelperFactory() {
    }
    public DaoHelper createDaoHelper() throws ConnectionException {
        return new DaoHelper(ConnectionPool.getInstance());
    }
}
