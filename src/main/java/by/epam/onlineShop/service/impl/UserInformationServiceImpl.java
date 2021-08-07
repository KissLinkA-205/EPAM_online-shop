package by.epam.onlineShop.service.impl;

import by.epam.onlineShop.dao.DaoFactory;
import by.epam.onlineShop.dao.impl.UserInformationDaoImpl;
import by.epam.onlineShop.entity.UserInformation;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.service.UserInformationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class UserInformationServiceImpl implements UserInformationService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public Optional<UserInformation> retrieveUserInformationById(long userInformationId) throws ServiceException {
        try {
            UserInformationDaoImpl userInformationDao = DaoFactory.getInstance().getUserInformationDao();
            Optional<UserInformation> result;
            result = userInformationDao.findById(userInformationId);
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve user information by id!");
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
