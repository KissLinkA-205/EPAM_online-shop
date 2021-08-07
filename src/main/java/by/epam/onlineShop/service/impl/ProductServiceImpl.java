package by.epam.onlineShop.service.impl;

import by.epam.onlineShop.dao.DaoFactory;
import by.epam.onlineShop.dao.ProductDao;
import by.epam.onlineShop.entity.Product;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<Product> retrieveProductsByCategory(long categoryId) throws ServiceException {
        try {
            ProductDao productDao = DaoFactory.getInstance().getProductDao();
            List<Product> result = null;
            result = productDao.findByCategory(categoryId);
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve products by category!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Product> retrieveProductById(long productId) throws ServiceException {
        try {
            ProductDao productDao = DaoFactory.getInstance().getProductDao();
            Optional<Product> result;
            result = productDao.findById(productId);
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve product by id!");
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
