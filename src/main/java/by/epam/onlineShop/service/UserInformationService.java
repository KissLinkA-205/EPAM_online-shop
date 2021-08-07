package by.epam.onlineShop.service;

import by.epam.onlineShop.entity.UserInformation;
import by.epam.onlineShop.exeptions.ServiceException;

import java.util.Optional;

public interface UserInformationService {

    /**
     * Method to retrieve user information by ID
     *
     * @param userInformationId ID of user information to retrieve
     * @return optional of UserInformation
     * @throws ServiceException
     */
    Optional<UserInformation> retrieveUserInformationById(long userInformationId) throws ServiceException;
}
