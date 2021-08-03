package by.epam.onlineShop.dao.UserDao;

import by.epam.onlineShop.connection.ProxyConnection;
import by.epam.onlineShop.dao.AbstractDao;
import by.epam.onlineShop.entity.User;
import by.epam.onlineShop.entity.UserInformation;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.mapper.RowMapperFactory;

import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM " + User.TABLE + " WHERE email=? and password=SHA1(?)";
    private static final String ADD_USER = "INSERT INTO" +  User.TABLE + " (email, password, role_id, userInformation_id) VALUES (?, ?, ?, ?)";


    public UserDaoImpl(ProxyConnection connection) {
        super(connection, RowMapperFactory.createMapper(User.TABLE), User.TABLE);
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {
        return executeQueryForSingleResult(FIND_BY_LOGIN_AND_PASSWORD, login, password);
    }

    @Override
    public long addUser(String email, String password, long userInformationId, long roleId) throws DaoException {
        return executeInsertQuery(ADD_USER, email, password, roleId, userInformationId);
    }
}
