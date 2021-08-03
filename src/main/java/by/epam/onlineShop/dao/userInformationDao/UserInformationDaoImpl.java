package by.epam.onlineShop.dao.userInformationDao;

import by.epam.onlineShop.connection.ProxyConnection;
import by.epam.onlineShop.dao.AbstractDao;
import by.epam.onlineShop.entity.User;
import by.epam.onlineShop.entity.UserInformation;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.mapper.RowMapperFactory;

public class UserInformationDaoImpl extends AbstractDao<UserInformation> {
    private static final String ADD_USER_INFORMATION = "INSERT INTO " +  UserInformation.TABLE + " (name, surname, patronymic, phone) VALUES (?, ?, ?, ?)";

    public UserInformationDaoImpl(ProxyConnection connection) {
        super(connection, RowMapperFactory.createMapper(UserInformation.TABLE), UserInformation.TABLE);
    }

    public long addUserInformation(String name, String surname, String patronymic, long phone) throws DaoException {
        return executeInsertQuery(ADD_USER_INFORMATION, name, surname, patronymic, phone);
    }
}
