package by.epam.onlineShop.dao.impl;

import by.epam.onlineShop.dao.AbstractDao;
import by.epam.onlineShop.dao.ProductDao;
import by.epam.onlineShop.dao.Table;
import by.epam.onlineShop.dao.mapper.RowMapperFactory;
import by.epam.onlineShop.entity.Product;
import by.epam.onlineShop.exeptions.DaoException;

import java.util.List;

public class ProductDaoImpl extends AbstractDao<Product> implements ProductDao {
    private static final String FIND_PRODUCTS_BY_CATEGORY_ID = "SELECT * FROM " + Table.PRODUCT + " WHERE category_id=?";
    private static final String SAVE_PRODUCT_QUERY = "INSERT INTO " + Table.PRODUCT +
            " (name, description, price, status, photo, orders_number) VALUES (?, ?, ?, ?, ?, ?)";

    public ProductDaoImpl() {
        super(RowMapperFactory.getInstance().getProductRowMapper(), Table.PRODUCT);
    }

    @Override
    public List<Product> findByCategory(long categoryId) throws DaoException {
        return executeQuery(FIND_PRODUCTS_BY_CATEGORY_ID, categoryId);
    }

    @Override
    public long save(Product product) throws DaoException {
        return executeInsertQuery(SAVE_PRODUCT_QUERY, product.getName(), product.getDescription(),
                product.getPrice(), product.isStatus(), product.getPhoto(), product.getPhoto());
    }

}
