package by.epam.onlineShop.dao.impl;

import by.epam.onlineShop.dao.AbstractDao;
import by.epam.onlineShop.dao.RoleDao;
import by.epam.onlineShop.dao.Table;
import by.epam.onlineShop.dao.mapper.RowMapperFactory;
import by.epam.onlineShop.entity.Role;
import by.epam.onlineShop.exeptions.DaoException;

import java.util.Optional;

public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    private static final String SAVE_ROLE_QUERY = "INSERT INTO " + Table.ROLE + " (role) VALUES (?)";
    private static final String FIND_ROLE_BY_NAME_QUERY = "SELECT * FROM " + Table.ROLE + " WHERE role=?";

    public RoleDaoImpl() {
        super(RowMapperFactory.getInstance().getRoleRowMapper(), Table.ROLE);
    }

    @Override
    public long save(Role role) throws DaoException {
        return executeInsertQuery(SAVE_ROLE_QUERY, role.getName());
    }

    @Override
    public Optional<Role> findByName(String name) throws DaoException {
        return executeQueryForSingleResult(FIND_ROLE_BY_NAME_QUERY, name);
    }
}
