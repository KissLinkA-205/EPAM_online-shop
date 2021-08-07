package by.epam.onlineShop.service;

import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.entity.User;
import by.epam.onlineShop.exeptions.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    /**
     * Method to authenticate user
     *
     * @param email    user's email
     * @param password user's password
     * @return optional of User
     * @throws ServiceException
     */
    Optional<User> login(String email, String password) throws ServiceException;

    /**
     * Method to register new user
     *
     * @param name        user's name
     * @param surname     user's surname
     * @param patronymic  user's patronymic
     * @param email       user's email
     * @param phoneString user's phone string type
     * @param password    user's password
     * @return result of registration
     * @throws ServiceException
     */
    boolean register(String name, String surname, String patronymic, String email, String phoneString, String password) throws ServiceException;

    /**
     * Method to retrieve user by ID
     *
     * @param userId ID of user to retrieve
     * @return optional of User
     * @throws ServiceException
     */
    Optional<User> retrieveUserById(long userId) throws ServiceException;

    /**
     * Method to get users from orders
     *
     * @param orders List of orders
     * @return List of users
     * @throws ServiceException
     */
    List<User> getUsersFromOrders(List<Order> orders) throws ServiceException;
}
