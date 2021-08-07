package by.epam.onlineShop.service;

import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.entity.Product;
import by.epam.onlineShop.exeptions.ServiceException;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    /**
     * Method to retrieve products by category
     *
     * @param categoryId ID of category
     * @return List of products
     * @throws ServiceException
     */
    List<Product> retrieveProductsByCategory(long categoryId) throws ServiceException;

    /**
     * Method to retrieve product by ID
     *
     * @param productId ID of product to retrieve
     * @return optional of Product
     * @throws ServiceException
     */
    Optional<Product> retrieveProductById(long productId) throws ServiceException;

    /**
     * Method to get products from orders
     *
     * @param orders List of orders
     * @return List of products
     * @throws ServiceException
     */
    List<Product> getProductsFromOrders(List<Order> orders) throws ServiceException;
}
