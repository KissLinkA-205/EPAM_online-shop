package by.epam.onlineShop.dao.impl;

import by.epam.onlineShop.dao.AbstractDao;
import by.epam.onlineShop.dao.PromotionDao;
import by.epam.onlineShop.dao.Table;
import by.epam.onlineShop.dao.mapper.RowMapperFactory;
import by.epam.onlineShop.entity.Promotion;
import by.epam.onlineShop.exeptions.DaoException;

import java.util.Optional;

public class PromotionDaoImpl extends AbstractDao<Promotion> implements PromotionDao {
    private static final String SAVE_PROMOTION_QUERY = "INSERT INTO " + Table.PROMOTION +
            " (name, description, discount, beginning_date, expiration_date, photo) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String FIND_PROMOTION_BY_NAME_QUERY = "SELECT * FROM " + Table.PROMOTION + " WHERE name=?";

    public PromotionDaoImpl() {
        super(RowMapperFactory.getInstance().getPromotionRowMapper(), Table.PROMOTION);
    }

    @Override
    public long save(Promotion promotion) throws DaoException {
        return executeInsertQuery(SAVE_PROMOTION_QUERY, promotion.getName(), promotion.getDescription(),
                promotion.getDiscount(), promotion.getBeginningDate(), promotion.getExpirationDate(), promotion.getPhoto());
    }

    @Override
    public Optional<Promotion> findByName(String name) throws DaoException {
        return executeQueryForSingleResult(FIND_PROMOTION_BY_NAME_QUERY, name);
    }
}
