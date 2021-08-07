package by.epam.onlineShop.dao.mapper.impl;

import by.epam.onlineShop.dao.mapper.Column;
import by.epam.onlineShop.dao.mapper.RowMapper;
import by.epam.onlineShop.entity.Promotion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PromotionRowMapper implements RowMapper<Promotion> {

    @Override
    public Promotion map(ResultSet resultSet) throws SQLException {
        Promotion promotion = new Promotion();
        promotion.setId(resultSet.getLong(Column.ID));
        promotion.setName(resultSet.getString(Column.PROMOTION_NAME));
        promotion.setDescription(resultSet.getString(Column.PROMOTION_DESCRIPTION));
        promotion.setDiscount(resultSet.getByte(Column.PROMOTION_DISCOUNT));
        promotion.setBeginningDate(resultSet.getDate(Column.PROMOTION_BEGINNING_DATE));
        promotion.setExpirationDate(resultSet.getDate(Column.PROMOTION_EXPIRATION_DATE));
        promotion.setPhoto(resultSet.getString(Column.PROMOTION_PHOTO));
        return promotion;
    }
}
