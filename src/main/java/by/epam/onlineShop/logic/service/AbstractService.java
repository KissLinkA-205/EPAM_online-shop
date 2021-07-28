package by.epam.onlineShop.logic.service;

import by.epam.onlineShop.dao.catalogDao.CategoryDaoImpl;
import by.epam.onlineShop.dao.helper.DaoHelper;
import by.epam.onlineShop.dao.helper.DaoHelperFactory;
import by.epam.onlineShop.dao.promotionDao.PromotionDaoImpl;
import by.epam.onlineShop.entity.Category;
import by.epam.onlineShop.entity.Promotion;
import by.epam.onlineShop.exeptions.ConnectionException;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.exeptions.ServiceException;

import java.util.List;

public class AbstractService {
    protected final DaoHelperFactory daoHelperFactory;

    public AbstractService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<Category> getCategories() throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {
            CategoryDaoImpl dao = daoHelper.createCategoryDao();
            List<Category> result = null;
            result = dao.getAll();
            return result;
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
