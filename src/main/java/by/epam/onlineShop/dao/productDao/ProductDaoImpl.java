package by.epam.onlineShop.dao.productDao;

import by.epam.onlineShop.connection.ProxyConnection;
import by.epam.onlineShop.dao.AbstractDao;
import by.epam.onlineShop.entity.Product;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.mapper.RowMapperFactory;

import java.util.List;

public class ProductDaoImpl extends AbstractDao<Product> implements ProductDao {
    private static final String GET_PRODUCTS_BY_CATEGORY_ID = "SELECT * FROM " + Product.TABLE + " WHERE category_id=?";

    public ProductDaoImpl(ProxyConnection connection) {
        super(connection, RowMapperFactory.createMapper(Product.TABLE), Product.TABLE);
    }

    @Override
    public List<Product> getProductsByCategoryId(long categoryId) throws DaoException {
        return executeQuery(GET_PRODUCTS_BY_CATEGORY_ID, categoryId);
    }
}
