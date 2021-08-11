package by.epam.onlineShop.service;

import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.entity.UserOrder;
import by.epam.onlineShop.exeptions.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserOrderService {

    /**
     * Method to retrieve user orders by ID
     *
     * @param userOrderId ID of user order to retrieve
     * @return optional of UserOrder
     * @throws ServiceException
     */
    Optional<UserOrder> retrieveUserOrderById(long userOrderId) throws ServiceException;

    /**
     * Method to retrieve user orders by status
     *
     * @param status status of user order
     * @return List of user orders
     * @throws ServiceException
     */
    List<UserOrder> retrieveUserOrderByStatus(String status) throws ServiceException;

    /**
     * Method to update status in user order by ID
     *
     * @param userOrderId ID of user order to update
     * @param status      new user order status
     * @return {@code true} if user order status was successfully updated, {@code false} otherwise
     * @throws ServiceException
     */
    boolean updateStatusAtUserOrderById(long userOrderId, String status) throws ServiceException;

    /**
     * Method to add new user order
     *
     * @param orders             user's orders
     * @param address            user's address
     * @param deliveryDateString user order delivery date string type
     * @return {@code true} if user order was successfully added, {@code false} otherwise
     * @throws ServiceException
     */
    boolean addNewUserOrder(List<Order> orders, String address, String deliveryDateString, String cardholderName,
                            String cvvString, String cardNumberString, String monthString, String yearString, double totalPrice) throws ServiceException;

    /**
     * Method to get user orders from orders
     *
     * @param orders List of orders
     * @return List of user orders
     * @throws ServiceException
     */
    List<UserOrder> getUserOrdersFromOrders(List<Order> orders) throws ServiceException;
}
