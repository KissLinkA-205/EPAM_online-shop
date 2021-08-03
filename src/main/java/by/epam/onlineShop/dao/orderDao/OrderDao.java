package by.epam.onlineShop.dao.orderDao;

import by.epam.onlineShop.dao.Dao;
import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.entity.UserOrder;
import by.epam.onlineShop.exeptions.DaoException;

import java.util.List;

public interface OrderDao extends Dao<Order> {
    List<Order> getOrdersByUserOrder(long userOrderId) throws DaoException;
    List<Order> getOrders(long userId) throws DaoException;
}
