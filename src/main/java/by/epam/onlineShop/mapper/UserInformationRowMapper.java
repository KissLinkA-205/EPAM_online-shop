package by.epam.onlineShop.mapper;

import by.epam.onlineShop.entity.UserInformation;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInformationRowMapper implements RowMapper<UserInformation> {
    @Override
    public UserInformation map(ResultSet resultSet) throws SQLException {
        UserInformation userInformation = new UserInformation();
        userInformation.setId(resultSet.getLong("id"));
        userInformation.setName(resultSet.getString("name"));
        userInformation.setSurname(resultSet.getString("surname"));
        userInformation.setPatronymic(resultSet.getString("patronymic"));
        userInformation.setPhone(resultSet.getLong("phone"));
        return userInformation;
    }
}
