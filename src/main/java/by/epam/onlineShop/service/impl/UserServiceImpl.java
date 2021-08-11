package by.epam.onlineShop.service.impl;

import by.epam.onlineShop.dao.DaoFactory;
import by.epam.onlineShop.dao.UserDao;
import by.epam.onlineShop.dao.impl.RoleDaoImpl;
import by.epam.onlineShop.dao.impl.UserInformationDaoImpl;
import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.entity.Role;
import by.epam.onlineShop.entity.User;
import by.epam.onlineShop.entity.UserInformation;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.service.UserService;
import by.epam.onlineShop.service.validator.Validator;
import by.epam.onlineShop.service.validator.ValidatorFactory;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger();

    private static final String USER = "user";

    @Override
    public Optional<User> login(String email, String password) throws ServiceException {
        if (email == null || password == null) {
            return Optional.empty();
        }

        if (!isEmailValid(email)) {
            return Optional.empty();
        }

        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            return userDao.findByEmailAndPassword(email, password);
        } catch (DaoException e) {
            logger.error("Unable to login user!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean register(String name, String surname, String patronymic, String email, String phoneString, String password) throws ServiceException {
        if (name == null || surname == null || patronymic == null ||
                email == null || phoneString == null || password == null) {
            return false;
        }

        if (!(isEmailValid(email) && isUserInformationValid(name, surname, patronymic, phoneString))) {
            return false;
        }
        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            if (userDao.findByEmail(email).isPresent()) {
                return false;
            }
            RoleDaoImpl roleDao = DaoFactory.getInstance().getRoleDao();
            Optional<Role> role = roleDao.findByName(USER);
            if (!role.isPresent()) {
                return false;
            }
            long phone = Long.parseLong(phoneString);
            UserInformationDaoImpl userInformationDao = DaoFactory.getInstance().getUserInformationDao();
            UserInformation userInformation = buildUserInformation(name, surname, patronymic, phone);
            long userInformationId = userInformationDao.save(userInformation);

            User user = buildUser(email, password, userInformationId, role.get().getId());
            userDao.save(user);

            return true;
        } catch (DaoException e) {
            logger.error("Unable to register user!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<User> retrieveUserById(long userId) throws ServiceException {
        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            Optional<User> result;
            result = userDao.findById(userId);
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve user by id!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<User> getUsersFromOrders(List<Order> orders) throws ServiceException {
        List<User> users = new LinkedList<>();
        try {
            for (Order order : orders) {
                Optional<User> user = retrieveUserById(order.getUserId());
                if (user.isPresent()) {
                    if (!users.contains(user.get())) {
                        users.add(user.get());
                    }
                }
            }
        } catch (ServiceException e) {
            logger.error("Unable to retrieve users  from orders!");
            throw new ServiceException(e.getMessage(), e);
        }

        return users;
    }

    private boolean isEmailValid(String email) {
        Validator validator = ValidatorFactory.getInstance().getEmailValidator();
        return validator.isValid(email);
    }

    private boolean isUserInformationValid(String name, String surname, String patronymic, String phone) {
        Validator nameValidator = ValidatorFactory.getInstance().getNameValidator();
        Validator phoneValidator = ValidatorFactory.getInstance().getPhoneValidator();

        return nameValidator.isValid(name) && nameValidator.isValid(surname) && nameValidator.isValid(patronymic) &&
                phoneValidator.isValid(phone);
    }

    private UserInformation buildUserInformation(String name, String surname, String patronymic, long phone) {
        UserInformation userInformation = new UserInformation();
        userInformation.setName(name);
        userInformation.setSurname(surname);
        userInformation.setPatronymic(patronymic);
        userInformation.setPhone(phone);
        return userInformation;
    }

    private User buildUser(String email, String password, long userInformationId, long roleId) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(DigestUtils.sha1Hex(password));
        user.setUserInformationId(userInformationId);
        user.setRoleId(roleId);
        return user;
    }
}
