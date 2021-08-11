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

    /**
     * Method to add new promotion
     *
     * @param promotionName        name of promotion
     * @param photo                photo of promotion
     * @param beginningDateString  promotion beginning date String type
     * @param expirationDateString promotion expiration date String type
     * @param description          promotion description
     * @param discountString       promotion discount String type
     * @return {@code true} if promotion was successfully added, {@code false} otherwise
     * @throws ServiceException
     */
    boolean addNewPromotion(String promotionName, String photo, String beginningDateString, String expirationDateString,
                            String description, String discountString) throws ServiceException;

    /**
     * Method to check the relevance of the promotion
     *
     * @param promotion Optional of promotion
     * @return {@code true} if promotion is relevant, {@code false} otherwise
     * @throws ServiceException
     */
    boolean checkRelevanceOfPromotion(Optional<Promotion> promotion);
}
