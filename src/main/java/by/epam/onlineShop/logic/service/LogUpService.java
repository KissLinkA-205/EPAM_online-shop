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
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Optional;

public class LogUpService {
    private DaoHelperFactory daoHelperFactory;

    public LogUpService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public boolean register(String name, String surname, String patronymic, String email, long phone, String password) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {

            RoleDaoImpl roleDao = daoHelper.createRoleDao();
            Optional<Role> role = roleDao.findRoleByName("user");
            if(role.isPresent()) {
                UserInformationDaoImpl userInformationDao = daoHelper.createUserInformationDao();
                long userInformationId = userInformationDao.addUserInformation(name, surname, patronymic, phone);
                System.out.println(userInformationId);
            }

            return true;
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
