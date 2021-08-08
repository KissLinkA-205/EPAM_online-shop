package by.epam.onlineShop.dao;

import by.epam.onlineShop.entity.User;
import by.epam.onlineShop.exeptions.DaoException;

import java.util.Optional;

public interface UserDao extends Dao<User> {

    /**
     * Method to get user by email and password from data base
     *
     * @param email    user's email
     * @param password user's password
     * @return optional of User
     * @throws DaoException
     */
    Optional<User> findByEmailAndPassword(String email, String password) throws DaoException;

    /**
     * Method to get user by email from data base
     *
     * @param email user's email
     * @return optional of User
     * @throws DaoException
     */
    Optional<User> findByEmail(String email) throws DaoException;
}
