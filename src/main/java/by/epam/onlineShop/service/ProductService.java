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

    /**
     * Method to add new product
     *
     * @param productName  name of product
     * @param photo        photo of product
     * @param priceString  price of product String type
     * @param categoryName name of product category
     * @param status       product status
     * @param description  description of product
     * @return {@code true} if product was successfully added, {@code false} otherwise
     * @throws ServiceException
     */
    boolean addNewProduct(String productName, String photo, String priceString, String categoryName,
                          boolean status, String description) throws ServiceException;

    /**
     * Method to update product information
     *
     * @param productName       name of product
     * @param photo             photo of product
     * @param priceString       price of product String type
     * @param categoryName      name of product category
     * @param status            product status
     * @param description       description of product
     * @param promotionIdString ID of product promotion
     * @return {@code true} if product was successfully updated, {@code false} otherwise
     * @throws ServiceException
     */
    boolean updateProductInformation(String productIdString, String productName, String photo, String priceString, String categoryName,
                                     boolean status, String description, String promotionIdString) throws ServiceException;
}
