package by.epam.onlineShop.dao.impl;

import by.epam.onlineShop.dao.AbstractDao;
import by.epam.onlineShop.dao.OrderDao;
import by.epam.onlineShop.dao.Table;
import by.epam.onlineShop.dao.mapper.RowMapperFactory;
import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.exeptions.DaoException;

import java.util.List;

public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {
    private static final String FIND_ORDERS_BY_USER_ID_AND_USER_ORDER_ID_WITHOUT_USER_ORDER_QUERY =
            "SELECT * FROM " + Table.ORDER + " WHERE user_id=? AND product_id=? AND userOrder_id IS NULL";
    private static final String FIND_ORDERS_BY_USER_ID_WITHOUT_USER_ORDER_QUERY = "SELECT * FROM " + Table.ORDER +
            " WHERE user_id=? AND userOrder_id IS NULL ORDER BY id DESC";
    private static final String FIND_ORDERS_BY_USER_ORDER_ID_QUERY = "SELECT * FROM " + Table.ORDER + " WHERE userOrder_id=?";
    private static final String FIND_ORDERS_BY_USER_ID_QUERY = "SELECT * FROM " + Table.ORDER + " WHERE user_id=? ORDER BY id DESC";
    private static final String UPDATE_USER_ORDER_QUERY = "UPDATE " + Table.ORDER + " SET userOrder_id=? WHERE id=?";
    private static final String SAVE_ORDER_QUERY = "INSERT INTO " + Table.ORDER + " (product_id, user_id, number) VALUES (?, ?, ?)";

    public OrderDaoImpl() {
        super(RowMapperFactory.getInstance().getOrderRowMapper(), Table.ORDER);
    }

    @Override
    public List<Order> findByUser(long userId) throws DaoException {
        return executeQuery(FIND_ORDERS_BY_USER_ID_QUERY, userId);
    }

    @Override
    public List<Order> findByUserOrder(long userOrderId) throws DaoException {
        return executeQuery(FIND_ORDERS_BY_USER_ORDER_ID_QUERY, userOrderId);
    }

    @Override
    public List<Order> findByUserWithoutUserOrder(long userId) throws DaoException {
        return executeQuery(FIND_ORDERS_BY_USER_ID_WITHOUT_USER_ORDER_QUERY, userId);
    }

    @Override
    public List<Order> findByUserAndProductWithoutUserOrder(long userId, long productId) throws DaoException {
        return executeQuery(FIND_ORDERS_BY_USER_ID_AND_USER_ORDER_ID_WITHOUT_USER_ORDER_QUERY, userId, productId);
    }

    @Override
    public void updateUserOrder(long id, long userOrderId) throws DaoException {
        executeUpdateQuery(UPDATE_USER_ORDER_QUERY, userOrderId, id);
    }

    @Override
    public long save(Order order) throws DaoException {
        return executeInsertQuery(SAVE_ORDER_QUERY, order.getProductId(), order.getUserId(), order.getNumber());
    }
}
