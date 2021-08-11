package by.epam.onlineShop.dao;

import by.epam.onlineShop.entity.Promotion;
import by.epam.onlineShop.exeptions.DaoException;

import java.util.Optional;

public interface PromotionDao extends Dao<Promotion> {

    /**
     * Method to get promotion by name from data base
     *
     * @param name name of promotion
     * @return optional of Promotion
     * @throws DaoException
     */
    Optional<Promotion> findByName(String name) throws DaoException;
}
