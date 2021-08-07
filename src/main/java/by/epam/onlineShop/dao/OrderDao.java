package by.epam.onlineShop.dao;

import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.exeptions.DaoException;

import java.util.List;

public interface OrderDao extends Dao<Order> {

    /**
     * Method to get orders by userOrderId in data base
     *
     * @param userOrderId user order ID
     * @return List of orders
     * @throws DaoException
     */
    List<Order> findOrdersByUserOrder(long userOrderId) throws DaoException;

    /**
     * Method to get orders by userId in data base
     *
     * @param userId user's ID
     * @return List of orders
     * @throws DaoException
     */
    List<Order> findOrdersByUser(long userId) throws DaoException;

    /**
     * Method to get orders by userId where user order is null in data base
     *
     * @param userId user's ID
     * @return List of orders
     * @throws DaoException
     */
    List<Order> findOrdersByUserWithoutUserOrder(long userId) throws DaoException;

    /**
     * Method to get orders by userId and productId where user order is null in data base
     *
     * @param userId    user's ID
     * @param productId product's id
     * @return List of orders
     * @throws DaoException
     */
    List<Order> findOrdersByUserAndProductWithoutUserOrder(long userId, long productId) throws DaoException;

    /**
     * Method to update userOrder in order by ID and userOrderId in data base
     *
     * @param id          ID of entity to update
     * @param userOrderId user order ID that will be updated
     * @throws DaoException
     */
    void updateUserOrder(long id, long userOrderId) throws DaoException;
}
