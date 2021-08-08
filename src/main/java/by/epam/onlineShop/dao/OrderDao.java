package by.epam.onlineShop.dao;

import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.exeptions.DaoException;

import java.util.List;

public interface OrderDao extends Dao<Order> {

    /**
     * Method to get orders by userOrderId from data base
     *
     * @param userOrderId user order ID
     * @return List of orders
     * @throws DaoException
     */
    List<Order> findByUserOrder(long userOrderId) throws DaoException;

    /**
     * Method to get orders by userId from data base
     *
     * @param userId user's ID
     * @return List of orders
     * @throws DaoException
     */
    List<Order> findByUser(long userId) throws DaoException;

    /**
     * Method to get orders by userId where user order is null from data base
     *
     * @param userId user's ID
     * @return List of orders
     * @throws DaoException
     */
    List<Order> findByUserWithoutUserOrder(long userId) throws DaoException;

    /**
     * Method to get orders by userId and productId where user order is null from data base
     *
     * @param userId    user's ID
     * @param productId product's id
     * @return List of orders
     * @throws DaoException
     */
    List<Order> findByUserAndProductWithoutUserOrder(long userId, long productId) throws DaoException;

    /**
     * Method to update userOrder in order by ID and userOrderId in data base
     *
     * @param id          ID of entity to update
     * @param userOrderId user order ID that will be updated
     * @throws DaoException
     */
    void updateUserOrder(long id, long userOrderId) throws DaoException;
}
