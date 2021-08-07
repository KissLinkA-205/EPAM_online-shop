package by.epam.onlineShop.dao.mapper.impl;

import by.epam.onlineShop.dao.mapper.Column;
import by.epam.onlineShop.dao.mapper.RowMapper;
import by.epam.onlineShop.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product map(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getLong(Column.ID));
        product.setCategoryId(resultSet.getLong(Column.CATEGORY_ID));
        product.setPromotionId(resultSet.getLong(Column.PROMOTION_ID));
        product.setName(resultSet.getString(Column.PRODUCT_NAME));
        product.setDescription(resultSet.getString(Column.PRODUCT_DESCRIPTION));
        product.setPrice(resultSet.getDouble(Column.PRODUCT_PRICE));
        product.setStatus(resultSet.getBoolean(Column.PRODUCT_STATUS));
        product.setPhoto(resultSet.getString(Column.PRODUCT_PHOTO));
        product.setOrdersNumber(resultSet.getLong(Column.ORDERS_NUMBER));
        return product;
    }
}
