package by.epam.onlineShop.logic.service;

import by.epam.onlineShop.dao.UserDao.UserDao;
import by.epam.onlineShop.dao.helper.DaoHelper;
import by.epam.onlineShop.dao.helper.DaoHelperFactory;
import by.epam.onlineShop.dao.roleDao.RoleDaoImpl;
import by.epam.onlineShop.dao.userInformationDao.UserInformationDaoImpl;
import by.epam.onlineShop.entity.Role;
import by.epam.onlineShop.entity.User;
import by.epam.onlineShop.entity.UserInformation;
import by.epam.onlineShop.exeptions.ConnectionException;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.logic.validator.EmailValidator;
import by.epam.onlineShop.logic.validator.NameValidator;
import by.epam.onlineShop.logic.validator.PhoneValidator;
import by.epam.onlineShop.logic.validator.ValidatorHelper;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Optional;

public class LogUpService {
    private DaoHelperFactory daoHelperFactory;

    public LogUpService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public boolean register(String name, String surname, String patronymic, String email, String phoneString, String password) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {

            RoleDaoImpl roleDao = daoHelper.createRoleDao();
            Optional<Role> role = roleDao.findRoleByName("user");

            if (role.isPresent() && isInformationValid(name, surname, patronymic, email, phoneString)) {
                UserDao dao = daoHelper.createUserDao();
                Optional<User> user = dao.findUserByEmail(email);
                if (!user.isPresent()) {
                    long phone = Long.parseLong(phoneString);
                    UserInformationDaoImpl userInformationDao = daoHelper.createUserInformationDao();
                    long userInformationId = userInformationDao.addUserInformation(name, surname, patronymic, phone);
                    UserDao userDao = daoHelper.createUserDao();
                    userDao.addUser(email, password, role.get().getId(), userInformationId);
                    return true;
                }
            }

            return false;
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public boolean isInformationValid(String name, String surname, String patronymic, String email, String phone) {
        boolean result = false;
        ValidatorHelper validatorHelper = ValidatorHelper.getInstance();
        NameValidator nameValidator = validatorHelper.createNameValidator();
        EmailValidator emailValidator = validatorHelper.createEmailValidator();
        PhoneValidator phoneValidator = validatorHelper.createPhoneValidator();

        if (nameValidator.isValid(name) && nameValidator.isValid(surname) && nameValidator.isValid(patronymic)
                && emailValidator.isValid(email) && phoneValidator.isValid(phone)) {
            result = true;
        }
        return result;
    }
}
