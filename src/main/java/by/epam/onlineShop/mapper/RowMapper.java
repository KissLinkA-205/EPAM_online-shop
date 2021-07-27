package by.epam.onlineShop.mapper;

import by.epam.onlineShop.entity.Identifiable;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T extends Identifiable> {
    T map(ResultSet resultSet) throws SQLException;
}
