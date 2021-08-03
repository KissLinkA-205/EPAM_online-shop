package by.epam.onlineShop.mapper;

import by.epam.onlineShop.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User map(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setUserInformationId(resultSet.getLong("userInformation_id"));
        user.setRoleId(resultSet.getLong("role_id"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}
