package by.epam.onlineShop.service.impl;

import by.epam.onlineShop.dao.CategoryDao;
import by.epam.onlineShop.dao.DaoFactory;
import by.epam.onlineShop.dao.ProductDao;
import by.epam.onlineShop.dao.PromotionDao;
import by.epam.onlineShop.entity.Category;
import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.entity.Product;
import by.epam.onlineShop.entity.Promotion;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.service.ProductService;
import by.epam.onlineShop.service.validator.Validator;
import by.epam.onlineShop.service.validator.ValidatorFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
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

    @Override
    public List<Product> getProductsFromOrders(List<Order> orders) throws ServiceException {
        List<Product> products = new LinkedList<>();

        for (Order order : orders) {
            Optional<Product> product = retrieveProductById(order.getProductId());
            if (product.isPresent()) {
                if (!products.contains(product.get())) {
                    products.add(product.get());
                }
            }
        }
        return products;
    }

    @Override
    public boolean addNewProduct(String productName, String photo, String priceString, String categoryName, boolean status, String description) throws ServiceException {
        if (productName == null || photo == null || categoryName == null || description == null) {
            return false;
        }

        Validator priceValidator = ValidatorFactory.getInstance().getPriceValidator();
        if (!priceValidator.isValid(priceString)) {
            return false;
        }

        try {
            ProductDao productDao = DaoFactory.getInstance().getProductDao();
            Optional<Product> productExist = productDao.findByName(productName);
            if (productExist.isPresent()) {
                return false;
            }

            long categoryId = getCategoryId(categoryName);

            double price = Double.parseDouble(priceString);
            Product product = buildProduct(categoryId, productName, description, price, status, photo);
            productDao.save(product);

            return true;
        } catch (DaoException e) {
            logger.error("Unable to add product!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateProductInformation(String productIdString, String productName, String photo, String priceString, String categoryName, boolean status, String description, String promotionIdString) throws ServiceException {
        if (productIdString == null || productName == null || photo == null || priceString == null ||
                categoryName == null || description == null || promotionIdString == null) {
            return false;
        }

        Validator priceValidator = ValidatorFactory.getInstance().getPriceValidator();
        if (!priceValidator.isValid(priceString)) {
            return false;
        }

        Validator idValidator = ValidatorFactory.getInstance().getIdValidator();
        if (!(idValidator.isValid(promotionIdString) || idValidator.isValid(productIdString))) {
            return false;
        }

        long categoryId = getCategoryId(categoryName);
        long promotionId = Long.parseLong(promotionIdString);
        long productId = Long.parseLong(productIdString);
        try {
            PromotionDao promotionDao = DaoFactory.getInstance().getPromotionDao();
            Optional<Promotion> promotion = promotionDao.findById(promotionId);
            if (!(promotion.isPresent() || promotionId == 0)) {
                return false;
            }

            double price = Double.parseDouble(priceString);
            ProductDao productDao = DaoFactory.getInstance().getProductDao();
            Product product = buildProduct(categoryId, productName, description, price, status, photo);
            product.setPromotionId(promotionId);
            productDao.updateById(productId, product);

            if (promotionId == 0) {
                productDao.removePromotionById(productId);
            } else {
                productDao.updatePromotionById(productId, promotionId);
            }

            return true;
        } catch (DaoException e) {
            logger.error("Unable to update product!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    private Product buildProduct(long categoryId, String name, String description, double price,
                                 boolean status, String photo) {
        Product product = new Product();
        product.setCategoryId(categoryId);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setStatus(status);
        product.setPhoto(photo);
        return product;
    }

    private long getCategoryId(String categoryName) throws ServiceException {
        try {
            CategoryDao categoryDao = DaoFactory.getInstance().getCategoryDao();
            Optional<Category> categoryExist = categoryDao.findByName(categoryName);

            long categoryId;
            if (categoryExist.isPresent()) {
                categoryId = categoryExist.get().getId();
            } else {
                Category category = new Category();
                category.setCategoryName(categoryName);
                categoryId = categoryDao.save(category);
            }
            return categoryId;
        } catch (DaoException e) {
            logger.error("Unable to get category id!");
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
