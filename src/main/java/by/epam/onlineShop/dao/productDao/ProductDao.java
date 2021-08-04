package by.epam.onlineShop.dao.productDao;

import by.epam.onlineShop.dao.Dao;
import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.entity.Product;
import by.epam.onlineShop.exeptions.DaoException;

import java.util.List;

public interface ProductDao extends Dao<Product> {
    List<Product> getProductsByCategoryId(long categoryId) throws DaoException;
}
