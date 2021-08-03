package by.epam.onlineShop.mapper;

import by.epam.onlineShop.entity.Category;
import by.epam.onlineShop.entity.Promotion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<Category> {

    @Override
    public Category map(ResultSet resultSet) throws SQLException {
        Category category = new Category();
        category.setId(resultSet.getLong("id"));
        category.setCategoryName(resultSet.getString("category"));
        return category;
    }
}
