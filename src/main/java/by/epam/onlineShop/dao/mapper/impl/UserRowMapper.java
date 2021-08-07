package by.epam.onlineShop.dao.mapper.impl;

import by.epam.onlineShop.dao.mapper.Column;
import by.epam.onlineShop.dao.mapper.RowMapper;
import by.epam.onlineShop.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User map(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong(Column.ID));
        user.setUserInformationId(resultSet.getLong(Column.USER_INFORMATION_ID));
        user.setRoleId(resultSet.getLong(Column.ROLE_ID));
        user.setEmail(resultSet.getString(Column.USER_EMAIL));
        user.setPassword(resultSet.getString(Column.USER_PASSWORD));
        return user;
    }
}
