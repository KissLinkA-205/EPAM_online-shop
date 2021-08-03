package by.epam.onlineShop.dao.userOrdersDao;

import by.epam.onlineShop.dao.Dao;
import by.epam.onlineShop.entity.UserOrder;
import by.epam.onlineShop.exeptions.DaoException;

import java.util.List;

public interface UserOrderDao extends Dao<UserOrder> {
    List<UserOrder> getUserOrders(long userId) throws DaoException;
}
