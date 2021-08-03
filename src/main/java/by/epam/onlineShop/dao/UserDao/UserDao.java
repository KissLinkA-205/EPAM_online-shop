package by.epam.onlineShop.dao.UserDao;

import by.epam.onlineShop.dao.Dao;
import by.epam.onlineShop.entity.User;
import by.epam.onlineShop.exeptions.DaoException;

import java.util.Optional;

public interface UserDao extends Dao<User> {
    Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException;

    long addUser(String email, String password, long userInformationId, long roleId) throws DaoException;
}
