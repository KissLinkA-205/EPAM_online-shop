package by.epam.onlineShop.dao;

import by.epam.onlineShop.entity.Category;
import by.epam.onlineShop.exeptions.DaoException;

import java.util.Optional;

public interface CategoryDao extends Dao<Category> {

    Optional<Category> findByName(String name) throws DaoException;
}
