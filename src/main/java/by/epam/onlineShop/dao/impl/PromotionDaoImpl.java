package by.epam.onlineShop.dao.impl;

import by.epam.onlineShop.dao.AbstractDao;
import by.epam.onlineShop.dao.Table;
import by.epam.onlineShop.dao.mapper.RowMapperFactory;
import by.epam.onlineShop.entity.Promotion;
import by.epam.onlineShop.exeptions.DaoException;

public class PromotionDaoImpl extends AbstractDao<Promotion> {
    private static final String SAVE_PROMOTION_QUERY = "INSERT INTO " + Table.PROMOTION +
            " (name, description, discount, beginning_date, expiration_date, photo) VALUES (?, ?, ?, ?, ?, ?)";

    public PromotionDaoImpl() {
        super(RowMapperFactory.getInstance().getPromotionRowMapper(), Table.PROMOTION);
    }

    @Override
    public long save(Promotion promotion) throws DaoException {
        return executeInsertQuery(SAVE_PROMOTION_QUERY, promotion.getName(), promotion.getDescription(),
                promotion.getDiscount(), promotion.getBeginningDate(), promotion.getExpirationDate(), promotion.getPhoto());
    }
}
