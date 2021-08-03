package by.epam.onlineShop.mapper;

import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.entity.UserOrder;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {

    @Override
    public Order map(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getLong("id"));
        order.setUserId(resultSet.getLong("user_id"));
        order.setUserOrderId(resultSet.getLong("userOrder_id"));
        order.setProductId(resultSet.getLong("product_id"));
        order.setNumber(resultSet.getInt("number"));
        return order;
    }
}
