package by.epam.onlineShop.service.impl;

import by.epam.onlineShop.dao.DaoFactory;
import by.epam.onlineShop.dao.impl.PromotionDaoImpl;
import by.epam.onlineShop.entity.Product;
import by.epam.onlineShop.entity.Promotion;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.service.PromotionService;
import by.epam.onlineShop.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PromotionServiceImpl implements PromotionService {
    private static final Logger logger = LogManager.getLogger();

    private static final int HUNDRED_PERCENT = 100;

    @Override
    public List<Promotion> retrievePromotions() throws ServiceException {
        try {
            PromotionDaoImpl promotionDao = DaoFactory.getInstance().getPromotionDao();
            List<Promotion> result = null;
            result = promotionDao.findAll();
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve promotions!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Promotion> retrievePromotionById(long promotionId) throws ServiceException {
        try {
            PromotionDaoImpl promotionDao = DaoFactory.getInstance().getPromotionDao();
            Optional<Promotion> result;
            result = promotionDao.findById(promotionId);
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve promotion by id!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Double calculateNewPrice(double price, int discount) {
        return price * discount / HUNDRED_PERCENT;
    }

    @Override
    public Map<String, Double> getNewPrices(List<Product> products) throws ServiceException {
        Map<String, Double> newPrices = new HashMap<>();

        for (Product product : products) {
            if (product.getPromotionId() != 0) {
                Optional<Promotion> promotion = retrievePromotionById(product.getPromotionId());
                if (promotion.isPresent()) {
                    Double newPrice = calculateNewPrice(product.getPrice(), promotion.get().getDiscount());
                    double scale = Math.pow(10, 2);
                    newPrice = Math.ceil(newPrice * scale) / scale;
                    newPrices.put(product.getName(), newPrice);
                }
            }
        }
        return newPrices;
    }
}
