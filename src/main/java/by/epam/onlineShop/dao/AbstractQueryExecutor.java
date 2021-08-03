package by.epam.onlineShop.dao;

import by.epam.onlineShop.connection.ProxyConnection;
import by.epam.onlineShop.entity.Identifiable;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.mapper.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AbstractQueryExecutor<T extends Identifiable> {
    private final RowMapper<T> rowMapper;
    private final ProxyConnection connection;

    private static final String EXCEPTION_ARGUMENT = "More then one record found";

    public AbstractQueryExecutor(RowMapper<T> rowMapper, ProxyConnection connection) {
        this.rowMapper = rowMapper;
        this.connection = connection;
    }

    protected Optional<T> executeQueryForSingleResult(String query, Object... params) throws DaoException {
        List<T> items = executeQuery(query, params);
        if (items.isEmpty()) {
            return Optional.empty();
        } else if (items.size() == 1) {
            return Optional.of(items.get(0));
        }
        throw new IllegalArgumentException(EXCEPTION_ARGUMENT);
    }

    protected List<T> executeQuery(String query, Object... params) throws DaoException {
        List<T> entities = new ArrayList<>();
        try (PreparedStatement statement = createStatement(query, params);
             ResultSet resultSet = statement.executeQuery()) {
            entities = createEntitiesList(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
        return entities;
    }

    protected long executeInsertQuery(String query, Object... params) throws DaoException {
        long result = 0;
        try (PreparedStatement statement = createStatement(query, params)) {
             statement.executeUpdate();
             ResultSet generatedKey = statement.getGeneratedKeys();
            if (generatedKey.next()) {
                result = generatedKey.getLong(1);
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
        return result;
    }

    private PreparedStatement createStatement(String query, Object... params) throws DaoException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            return preparedStatement;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    private List<T> createEntitiesList(ResultSet resultSet) throws DaoException {
        List<T> entities = new ArrayList<>();
        try {
            while (resultSet.next()) {
                T entity = rowMapper.map(resultSet);
                entities.add(entity);
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
        return entities;
    }
}
