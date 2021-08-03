package by.epam.onlineShop.mapper;

import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product map(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getLong("id"));
        product.setCategoryId(resultSet.getLong("category_id"));
        product.setPromotionId(resultSet.getLong("promotion_id"));
        product.setName(resultSet.getString("name"));
        product.setDescription(resultSet.getString("description"));
        product.setPrice(resultSet.getDouble("price"));
        product.setStatus(resultSet.getBoolean("status"));
        product.setPhoto(resultSet.getString("photo"));
        product.setOrdersNumber(resultSet.getLong("orders_number"));
        return product;
    }
}
