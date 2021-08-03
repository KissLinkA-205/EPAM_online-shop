package by.epam.onlineShop.mapper;

import by.epam.onlineShop.entity.User;
import by.epam.onlineShop.entity.UserOrder;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserOrderRowMapper implements RowMapper<UserOrder>{

    @Override
    public UserOrder map(ResultSet resultSet) throws SQLException {
        UserOrder userOrder = new UserOrder();
        userOrder.setId(resultSet.getLong("id"));
        userOrder.setAddress(resultSet.getString("address"));
        userOrder.setOrderDate(resultSet.getDate("order_date"));
        userOrder.setDeliveryDate(resultSet.getDate("delivery_date"));
        userOrder.setStatus(resultSet.getString("status"));
        return userOrder;
    }
}
