package by.epam.onlineShop.logic.service;

import by.epam.onlineShop.dao.helper.DaoHelper;
import by.epam.onlineShop.dao.helper.DaoHelperFactory;
import by.epam.onlineShop.dao.promotionDao.PromotionDaoImpl;
import by.epam.onlineShop.entity.Promotion;
import by.epam.onlineShop.exeptions.ConnectionException;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.exeptions.ServiceException;

import java.util.List;

public class PromotionsService extends AbstractService{

    public PromotionsService(DaoHelperFactory daoHelperFactory) {
        super(daoHelperFactory);
    }

    public List<Promotion> getPromotions() throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {
            PromotionDaoImpl dao = daoHelper.createPromotionDao();
            List<Promotion> result = null;
            result = dao.getAll();
            return result;
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}