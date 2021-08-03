package by.epam.onlineShop.dao;

import by.epam.onlineShop.exeptions.DaoException;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    List<T> getAll() throws DaoException;

    Optional<T> getById(long id) throws DaoException;
}
