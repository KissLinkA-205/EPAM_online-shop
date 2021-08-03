package by.epam.onlineShop.dao.productDao;

import by.epam.onlineShop.connection.ProxyConnection;
import by.epam.onlineShop.dao.AbstractDao;
import by.epam.onlineShop.entity.Product;
import by.epam.onlineShop.mapper.RowMapperFactory;

public class ProductDaoImpl extends AbstractDao<Product> {
    public ProductDaoImpl(ProxyConnection connection) {
        super(connection, RowMapperFactory.createMapper(Product.TABLE), Product.TABLE);
    }

}
