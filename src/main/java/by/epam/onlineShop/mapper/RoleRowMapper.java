package by.epam.onlineShop.mapper;

import by.epam.onlineShop.entity.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRowMapper implements RowMapper<Role> {

    @Override
    public Role map(ResultSet resultSet) throws SQLException {
        Role role = new Role();
        role.setId(resultSet.getLong("id"));
        role.setName(resultSet.getString("role"));
        return role;
    }
}