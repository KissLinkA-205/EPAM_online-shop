package by.epam.onlineShop.service;

import by.epam.onlineShop.entity.Product;
import by.epam.onlineShop.entity.Promotion;
import by.epam.onlineShop.exeptions.ServiceException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PromotionService {

    /**
     * Method to retrieve promotions
     *
     * @return List of promotions
     * @throws ServiceException
     */
    List<Promotion> retrievePromotions() throws ServiceException;

    /**
     * Method to retrieve promotion by ID
     *
     * @param promotionId ID of promotion to retrieve
     * @return optional of Promotion
     * @throws ServiceException
     */
    Optional<Promotion> retrievePromotionById(long promotionId) throws ServiceException;

    /**
     * Method to calculate new price
     *
     * @param price    old price
     * @param discount amount of discount
     * @return new price
     */
    Double calculateNewPrice(double price, int discount);

    /**
     * Method to get new price of products
     *
     * @param products List of products
     * @return Map with name of product and new price
     * @throws ServiceException
     */
    Map<String, Double> getNewPrices(List<Product> products) throws ServiceException;
}
