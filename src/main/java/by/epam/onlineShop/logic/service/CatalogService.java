package by.epam.onlineShop.logic.service;

import by.epam.onlineShop.dao.helper.DaoHelper;
import by.epam.onlineShop.dao.helper.DaoHelperFactory;
import by.epam.onlineShop.dao.productDao.ProductDao;
import by.epam.onlineShop.dao.promotionDao.PromotionDaoImpl;
import by.epam.onlineShop.dao.roleDao.RoleDaoImpl;
import by.epam.onlineShop.entity.Product;
import by.epam.onlineShop.entity.Promotion;
import by.epam.onlineShop.entity.Role;
import by.epam.onlineShop.exeptions.ConnectionException;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.exeptions.ServiceException;

import java.util.List;
import java.util.Optional;

public class CatalogService extends AbstractService {
    public CatalogService(DaoHelperFactory daoHelperFactory) {
        super(daoHelperFactory);
    }

    public List<Product> getProducts(long categoryId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {
            ProductDao dao = daoHelper.createProductDao();
            List<Product> result = null;
            result = dao.getProductsByCategoryId(categoryId);
            return result;
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public Optional<Promotion> getPromotionById(long promotionId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {

            PromotionDaoImpl dao = daoHelper.createPromotionDao();
            Optional<Promotion> result;
            result = dao.getById(promotionId);
            return result;
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public Double calculateNewPrice(double price, int discount) {
        int hundred_percent = 100;
        Double result = price * discount / hundred_percent;
        return result;
    }
}
