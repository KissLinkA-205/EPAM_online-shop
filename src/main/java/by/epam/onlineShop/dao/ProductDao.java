package by.epam.onlineShop.dao;

import by.epam.onlineShop.entity.Product;
import by.epam.onlineShop.exeptions.DaoException;

import java.util.List;
import java.util.Optional;

public interface ProductDao extends Dao<Product> {

    /**
     * Method to find product by category in data base
     *
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

    /**
     * Method to update product by ID in data base
     *
     * @param id      ID of product to update
     * @param product new product information
     * @throws DaoException
     */
    void updateById(long id, Product product) throws DaoException;

    /**
     * Method to update promotion by product ID in data base
     *
     * @param id          ID of product to update
     * @param promotionId new promotion
     * @throws DaoException
     */
    void updatePromotionById(long id, long promotionId) throws DaoException;

    /**
     * Method to remove promotion by product ID in data base
     *
     * @param id ID of product to update
     * @throws DaoException
     */
    void removePromotionById(long id) throws DaoException;
}
