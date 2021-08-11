package by.epam.onlineShop.dao.mapper.impl;

import by.epam.onlineShop.dao.mapper.Column;
import by.epam.onlineShop.entity.Promotion;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PromotionRowMapperTest {
    private static final long EXPECTED_LONG = 1L;
    private static final String EXPECTED_STRING = "test";
    private static final byte EXPECTED_BYTE = 1;
    private static final Date EXPECTED_DATE = new Date();

    @Test
    void testMap_ShouldReturnPromotion_WhenDataIsCorrect() throws SQLException {
        java.sql.Date sqlDate = new java.sql.Date(EXPECTED_DATE.getTime());

        ResultSet rsMock = Mockito.mock(ResultSet.class);
        Mockito.when(rsMock.getLong(Column.ID)).thenReturn(EXPECTED_LONG);
        Mockito.when(rsMock.getString(Column.PROMOTION_NAME)).thenReturn(EXPECTED_STRING);
        Mockito.when(rsMock.getString(Column.PROMOTION_DESCRIPTION)).thenReturn(EXPECTED_STRING);
        Mockito.when(rsMock.getByte(Column.PROMOTION_DISCOUNT)).thenReturn(EXPECTED_BYTE);
        Mockito.when(rsMock.getDate(Column.PROMOTION_BEGINNING_DATE)).thenReturn(sqlDate);
        Mockito.when(rsMock.getDate(Column.PROMOTION_EXPIRATION_DATE)).thenReturn(sqlDate);
        Mockito.when(rsMock.getString(Column.PROMOTION_PHOTO)).thenReturn(EXPECTED_STRING);

        PromotionRowMapper promotionRowMapper = new PromotionRowMapper();
        Promotion actual = promotionRowMapper.map(rsMock);

        Promotion expected = new Promotion();
        expected.setId(EXPECTED_LONG);
        expected.setName(EXPECTED_STRING);
        expected.setDescription(EXPECTED_STRING);
        expected.setDiscount(EXPECTED_BYTE);
        expected.setBeginningDate(sqlDate);
        expected.setExpirationDate(sqlDate);
        expected.setPhoto(EXPECTED_STRING);

        assertEquals(expected, actual);
    }
}