package by.epam.onlineShop.dao.impl;

import by.epam.onlineShop.dao.AbstractDao;
import by.epam.onlineShop.dao.CategoryDao;
import by.epam.onlineShop.dao.Table;
import by.epam.onlineShop.dao.mapper.RowMapperFactory;
import by.epam.onlineShop.entity.Category;
import by.epam.onlineShop.exeptions.DaoException;

import java.util.Optional;

public class CategoryDaoImpl extends AbstractDao<Category> implements CategoryDao {
    private static final String SAVE_CATEGORY_QUERY = "INSERT INTO " + Table.CATEGORY + " (category) VALUES (?)";
    private static final String FIND_CATEGORY_BY_NAME_QUERY = "SELECT * FROM " + Table.CATEGORY + " WHERE category=?";

    public CategoryDaoImpl() {
        super(RowMapperFactory.getInstance().getCategoryRowMapper(), Table.CATEGORY);
    }

    @Override
    public long save(Category category) throws DaoException {
        return executeInsertQuery(SAVE_CATEGORY_QUERY, category.getCategoryName());
    }

    @Override
    public Optional<Category> findByName(String name) throws DaoException {
        return executeQueryForSingleResult(FIND_CATEGORY_BY_NAME_QUERY, name);
    }
}
