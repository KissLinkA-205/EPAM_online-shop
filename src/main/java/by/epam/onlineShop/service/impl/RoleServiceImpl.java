package by.epam.onlineShop.service.impl;

import by.epam.onlineShop.dao.DaoFactory;
import by.epam.onlineShop.dao.RoleDao;
import by.epam.onlineShop.entity.Role;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.service.RoleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class RoleServiceImpl implements RoleService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public Optional<Role> retrieveRoleById(long roleId) throws ServiceException {
        try {
            RoleDao roleDao = DaoFactory.getInstance().getRoleDao();
            Optional<Role> result;
            result = roleDao.findById(roleId);
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve role by id!");
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
