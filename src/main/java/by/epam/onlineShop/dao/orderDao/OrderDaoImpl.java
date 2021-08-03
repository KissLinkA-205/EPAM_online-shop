package by.epam.onlineShop.dao.orderDao;

import by.epam.onlineShop.connection.ProxyConnection;
import by.epam.onlineShop.dao.AbstractDao;
import by.epam.onlineShop.dao.userOrdersDao.UserOrderDao;
import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.entity.UserOrder;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.mapper.RowMapperFactory;

import java.util.List;

public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {
    private static final String GET_ORDERS_BY_USER_ORDER_ID = "SELECT * FROM " + Order.TABLE + " WHERE userOrder_id=?";
    private static final String GET_ORDERS_WITHOUT_USER_ORDER = "SELECT * FROM " + Order.TABLE + " WHERE user_id=? AND userOrder_id IS NULL ORDER BY id DESC";
    private static final String GET_ORDERS_BY_USER_ID = "SELECT * FROM " + Order.TABLE + " WHERE user_id=? ORDER BY id DESC";

    public OrderDaoImpl(ProxyConnection connection) {
        super(connection, RowMapperFactory.createMapper(Order.TABLE), Order.TABLE);
    }

    @Override
    public List<Order> getOrders(long userId) throws DaoException {
        return executeQuery(GET_ORDERS_BY_USER_ID, userId);
    }

    @Override
    public List<Order> getOrdersByUserOrder(long userOrderId) throws DaoException {
        return executeQuery(GET_ORDERS_BY_USER_ORDER_ID, userOrderId);
    }

    public List<Order> getOrdersWithoutUserOrder(long userId) throws DaoException {
        return executeQuery(GET_ORDERS_WITHOUT_USER_ORDER, userId);
    }
}
