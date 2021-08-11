package by.epam.onlineShop.service;

import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.entity.UserOrder;
import by.epam.onlineShop.exeptions.ServiceException;

import java.util.List;

public interface OrderService {

    /**
     * Method to retrieve orders by user ID where user order is null
     *
     * @param userId ID of user
     * @return List of orders
     * @throws ServiceException
     */
    List<Order> retrieveOrdersByUserWithoutUserOrder(long userId) throws ServiceException;

    /**
     * Method to retrieve orders by user ID
     *
     * @param userId ID of user
     * @return List of orders
     * @throws ServiceException
     */
    List<Order> retrieveOrdersByUser(long userId) throws ServiceException;

    /**
     * Method to retrieve orders by user ID where user order is null and status is true
     *
     * @param userId ID of user
     * @return List of orders
     * @throws ServiceException
     */
    List<Order> retrieveOrdersByUserWhereProductStatusTrue(long userId) throws ServiceException;

    /**
     * Method to retrieve orders by user order
     *
     * @param userOrderId ID of user order
     * @return List of orders
     * @throws ServiceException
     */
    List<Order> retrieveOrdersByUserOrder(long userOrderId) throws ServiceException;

    /**
     * Method to remove order by ID
     *
     * @param orderId ID of order to remove
     * @return {@code true} if order was successfully deleted, {@code false} otherwise
     * @throws ServiceException
     */
    boolean removeOrderById(long orderId) throws ServiceException;

    /**
     * Method to add new order
     *
     * @param userId    user's ID
     * @param productId product's ID
     * @param number    number of products
     * @return {@code true} if order was successfully added, {@code false} otherwise
     * @throws ServiceException
     */
    boolean addNewOrder(long userId, long productId, int number) throws ServiceException;

    /**
     * Method to calculate total cost of orders
     *
     * @param orders List of orders
     * @return total cost
     * @throws ServiceException
     */
    double calculateTotalCost(List<Order> orders) throws ServiceException;

    /**
     * Method to get orders from user orders
     *
     * @param userOrders List of user orders
     * @return List of orders
     * @throws ServiceException
     */
    List<Order> getOrdersFromUserOrders(List<UserOrder> userOrders) throws ServiceException;
}
