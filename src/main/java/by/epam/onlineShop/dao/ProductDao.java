package by.epam.onlineShop.dao;

import by.epam.onlineShop.dao.Dao;
import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.entity.Product;
import by.epam.onlineShop.exeptions.DaoException;

import java.util.List;
import java.util.Optional;

public interface ProductDao extends Dao<Product> {

    /**
     * Method to find product by category in data base
     * @param categoryId category ID
     * @return List of products
     * @throws DaoException
     */
    List<Product> findByCategory(long categoryId) throws DaoException;

    /**
     * Method to get product by name from data base
     *
     * @param name name of product
     * @return Optional of product
     * @throws DaoException
     */
    Optional<Product> findByName(String name) throws DaoException;
}
