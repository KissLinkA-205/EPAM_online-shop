package by.epam.onlineShop.logic.service;

import by.epam.onlineShop.dao.helper.DaoHelper;
import by.epam.onlineShop.dao.helper.DaoHelperFactory;
import by.epam.onlineShop.dao.promotionDao.PromotionDaoImpl;
import by.epam.onlineShop.dao.userInformationDao.UserInformationDaoImpl;
import by.epam.onlineShop.entity.Promotion;
import by.epam.onlineShop.entity.UserInformation;
import by.epam.onlineShop.exeptions.ConnectionException;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.exeptions.ServiceException;

import java.util.List;
import java.util.Optional;

public class ProfileService {
    private final DaoHelperFactory daoHelperFactory;

    public ProfileService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public Optional<UserInformation> getInformation(long id) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {
            UserInformationDaoImpl dao = daoHelper.createUserInformationDao();
            Optional<UserInformation> result = null;
            result = dao.getById(id);
            return result;
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
