package by.epam.onlineShop.dao;

import by.epam.onlineShop.connection.ProxyConnection;
import by.epam.onlineShop.entity.Identifiable;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.mapper.RowMapper;

import java.util.List;

public abstract class AbstractDao<T extends Identifiable> extends AbstractQueryExecutor<T> implements Dao<T> {
    private final String tableName;

    public AbstractDao(ProxyConnection connection, RowMapper<T> rowMapper, String tableName) {
        super(rowMapper, connection);
        this.tableName = tableName;
    }

    @Override
    public List<T> getAll() throws DaoException {
        String query = "SELECT * FROM " + tableName;
        return executeQuery(query);
    }
}
