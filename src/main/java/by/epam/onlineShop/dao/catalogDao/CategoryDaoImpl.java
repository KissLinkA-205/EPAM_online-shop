package by.epam.onlineShop.dao.catalogDao;

import by.epam.onlineShop.connection.ProxyConnection;
import by.epam.onlineShop.dao.AbstractDao;
import by.epam.onlineShop.entity.Category;
import by.epam.onlineShop.entity.Promotion;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.mapper.RowMapperFactory;

import java.util.List;

public class CategoryDaoImpl extends AbstractDao<Category> {
    private static final String GET_ALL_QUERY = "SELECT * FROM " + Category.TABLE;

    public CategoryDaoImpl(ProxyConnection connection) {
        super(connection, RowMapperFactory.createMapper(Category.TABLE), Promotion.TABLE);
    }

    @Override
    public List<Category> getAll() throws DaoException {
        return executeQuery(GET_ALL_QUERY);
    }
}
