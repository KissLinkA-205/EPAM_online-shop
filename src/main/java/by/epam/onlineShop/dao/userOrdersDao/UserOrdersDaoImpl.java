package by.epam.onlineShop.dao.userOrdersDao;

import by.epam.onlineShop.connection.ProxyConnection;
import by.epam.onlineShop.dao.AbstractDao;
import by.epam.onlineShop.entity.User;
import by.epam.onlineShop.entity.UserOrder;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.mapper.RowMapperFactory;

import java.util.List;

public class UserOrdersDaoImpl extends AbstractDao<UserOrder> implements UserOrderDao {
    private static final String GET_USER_ORDERS_BY_ID = "SELECT * FROM " + UserOrder.TABLE + " WHERE user_id=? AND status IS NOT NULL ORDER BY id DESC";
private static final String GET_USER_ORDERS_BY_STATUS = "SELECT * FROM " + UserOrder.TABLE + " WHERE status=?";

    public UserOrdersDaoImpl(ProxyConnection connection) {
        super(connection, RowMapperFactory.createMapper(UserOrder.TABLE), UserOrder.TABLE);
    }

    @Override
    public List<UserOrder> getUserOrders(long userId) throws DaoException {
        return executeQuery(GET_USER_ORDERS_BY_ID, userId);
    }

    public List<UserOrder> getUserOrdersByStatus(String status) throws DaoException {
        return executeQuery(GET_USER_ORDERS_BY_STATUS, status);
    }
}
