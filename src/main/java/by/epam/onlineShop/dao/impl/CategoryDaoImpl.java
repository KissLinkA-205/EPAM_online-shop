package by.epam.onlineShop.dao.impl;

import by.epam.onlineShop.dao.AbstractDao;
import by.epam.onlineShop.dao.Table;
import by.epam.onlineShop.dao.mapper.RowMapperFactory;
import by.epam.onlineShop.entity.Category;
import by.epam.onlineShop.exeptions.DaoException;

public class CategoryDaoImpl extends AbstractDao<Category> {
    private static final String SAVE_CATEGORY_QUERY = "INSERT INTO " + Table.CATEGORY + " (category) VALUES (?)";

    public CategoryDaoImpl() {
        super(RowMapperFactory.getInstance().getCategoryRowMapper(), Table.CATEGORY);
    }

    @Override
    public long save(Category category) throws DaoException {
        return executeInsertQuery(SAVE_CATEGORY_QUERY, category.getCategoryName());
    }
}
