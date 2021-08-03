package by.epam.onlineShop.dao.promotionDao;

import by.epam.onlineShop.connection.ProxyConnection;
import by.epam.onlineShop.dao.AbstractDao;
import by.epam.onlineShop.dao.Dao;
import by.epam.onlineShop.entity.Promotion;
import by.epam.onlineShop.exeptions.DaoException;
import by.epam.onlineShop.mapper.RowMapper;
import by.epam.onlineShop.mapper.RowMapperFactory;

import java.util.List;

public class PromotionDaoImpl extends AbstractDao<Promotion> {

    public PromotionDaoImpl(ProxyConnection connection) {
        super(connection, RowMapperFactory.createMapper(Promotion.TABLE), Promotion.TABLE);
    }
}
