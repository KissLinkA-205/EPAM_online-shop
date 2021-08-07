package by.epam.onlineShop.service.impl;

import by.epam.onlineShop.dao.DaoFactory;
import by.epam.onlineShop.dao.impl.CategoryDaoImpl;
import by.epam.onlineShop.entity.Category;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.service.CategoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<Category> retrieveCategories() throws ServiceException {
        try {
            CategoryDaoImpl categoryDao = DaoFactory.getInstance().getCategoryDao();
            List<Category> result = null;
            result = categoryDao.findAll();
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve categories!");
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
