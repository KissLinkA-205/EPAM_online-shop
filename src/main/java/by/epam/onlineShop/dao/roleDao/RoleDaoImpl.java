package by.epam.onlineShop.dao.roleDao;

import by.epam.onlineShop.connection.ProxyConnection;
import by.epam.onlineShop.dao.AbstractDao;
import by.epam.onlineShop.entity.Promotion;
import by.epam.onlineShop.entity.Role;
import by.epam.onlineShop.entity.User;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.mapper.RowMapperFactory;

import java.util.Optional;

public class RoleDaoImpl extends AbstractDao<Role> {
    private static final String FIND_ROLE_BY_NAME = "SELECT * FROM " + Role.TABLE + " WHERE role=?";
    public RoleDaoImpl(ProxyConnection connection) {
        super(connection, RowMapperFactory.createMapper(Role.TABLE), Role.TABLE);
    }

    public Optional<Role> findRoleByName(String name) throws DaoException {
        return executeQueryForSingleResult(FIND_ROLE_BY_NAME, name);
    }
}
