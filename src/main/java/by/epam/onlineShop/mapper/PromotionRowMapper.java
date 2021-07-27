package by.epam.onlineShop.mapper;

import by.epam.onlineShop.entity.Promotion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PromotionRowMapper implements RowMapper<Promotion> {

    @Override
    public Promotion map(ResultSet resultSet) throws SQLException {
        Promotion promotion = new Promotion();
        promotion.setId(resultSet.getLong("id"));
        promotion.setName(resultSet.getString("name"));
        promotion.setDescription(resultSet.getString("description"));
        promotion.setDiscount(resultSet.getByte("discount"));
        promotion.setBeginningDate(resultSet.getDate("beginning_date"));
        promotion.setExpirationDate(resultSet.getDate("expiration_date"));
        promotion.setExpirationDate(resultSet.getDate("expiration_date"));
        promotion.setPhoto(resultSet.getString("photo"));
        return promotion;
    }
}
