package by.epam.onlineShop.dao.UserDao;

import by.epam.onlineShop.connection.ProxyConnection;
import by.epam.onlineShop.dao.AbstractDao;
import by.epam.onlineShop.entity.User;
import by.epam.onlineShop.entity.UserInformation;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.mapper.RowMapperFactory;

import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final String FIND_BY_EMAIL_AND_PASSWORD = "SELECT * FROM " + User.TABLE + " WHERE email=? and password=SHA1(?)";
    private static final String FIND_BY_EMAIL = "SELECT * FROM " + User.TABLE + " WHERE email=?";
    private static final String ADD_USER = "INSERT INTO " +  User.TABLE + " (email, password, role_id, userInformation_id) VALUES (?, ?, ?, ?)";


    public UserDaoImpl(ProxyConnection connection) {
        super(connection, RowMapperFactory.createMapper(User.TABLE), User.TABLE);
    }

    @Override
    public Optional<User> findUserByEmailAndPassword(String email, String password) throws DaoException {
        return executeQueryForSingleResult(FIND_BY_EMAIL_AND_PASSWORD, email, password);
    }

    @Override
    public long addUser(String email, String password, long roleId, long userInformationId) throws DaoException {
        return executeInsertQuery(ADD_USER, email, password, roleId, userInformationId);
    }

    @Override
    public Optional<User> findUserByEmail(String email) throws DaoException {
        return executeQueryForSingleResult(FIND_BY_EMAIL, email);
    }
}
