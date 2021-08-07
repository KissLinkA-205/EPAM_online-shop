package by.epam.onlineShop.dao;

import by.epam.onlineShop.dao.Dao;
import by.epam.onlineShop.entity.UserOrder;
import by.epam.onlineShop.exeptions.DaoException;

import java.util.List;

public interface UserOrderDao extends Dao<UserOrder> {

    /**
     * Method to get user orders by userId in data base
     *
     * @param userId user's ID
     * @return List of user orders
     * @throws DaoException
     */
    List<UserOrder> findByUser(long userId) throws DaoException;

    /**
     * Method to get user orders by status in data base
     *
     * @param status user order status
     * @return List of user orders
     * @throws DaoException
     */
    List<UserOrder> findByStatus(String status) throws DaoException;

    /**
     * Method to update status in user order by ID in data base
     *
     * @param id     ID of user order to update
     * @param status new user order status
     * @throws DaoException
     */
    void updateStatusById(long id, String status) throws DaoException;

}
