package by.epam.onlineShop.dao.mapper.impl;

import by.epam.onlineShop.dao.mapper.Column;
import by.epam.onlineShop.entity.Product;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductRowMapperTest {
    private static final long EXPECTED_LONG = 1L;
    private static final String EXPECTED_STRING = "test";
    private static final double EXPECTED_DOUBLE = 1.00;
    private static final boolean EXPECTED_BOOLEAN = true;

    @Test
    void testMap_ShouldReturnProduct_WhenDataIsCorrect() throws SQLException {
        ResultSet rsMock = Mockito.mock(ResultSet.class);
        Mockito.when(rsMock.getLong(Column.ID)).thenReturn(EXPECTED_LONG);
        Mockito.when(rsMock.getLong(Column.CATEGORY_ID)).thenReturn(EXPECTED_LONG);
        Mockito.when(rsMock.getLong(Column.PROMOTION_ID)).thenReturn(EXPECTED_LONG);
        Mockito.when(rsMock.getString(Column.PRODUCT_NAME)).thenReturn(EXPECTED_STRING);
        Mockito.when(rsMock.getString(Column.PRODUCT_DESCRIPTION)).thenReturn(EXPECTED_STRING);
        Mockito.when(rsMock.getDouble(Column.PRODUCT_PRICE)).thenReturn(EXPECTED_DOUBLE);
        Mockito.when(rsMock.getBoolean(Column.PRODUCT_STATUS)).thenReturn(EXPECTED_BOOLEAN);
        Mockito.when(rsMock.getString(Column.PRODUCT_PHOTO)).thenReturn(EXPECTED_STRING);
        Mockito.when(rsMock.getLong(Column.ORDERS_NUMBER)).thenReturn(EXPECTED_LONG);

        ProductRowMapper productRowMapper = new ProductRowMapper();
        Product actual = productRowMapper.map(rsMock);

        Product expected = new Product();
        expected.setId(EXPECTED_LONG);
        expected.setCategoryId(EXPECTED_LONG);
        expected.setPromotionId(EXPECTED_LONG);
        expected.setName(EXPECTED_STRING);
        expected.setDescription(EXPECTED_STRING);
        expected.setPrice(EXPECTED_DOUBLE);
        expected.setStatus(EXPECTED_BOOLEAN);
        expected.setPhoto(EXPECTED_STRING);
        expected.setOrdersNumber(EXPECTED_LONG);

        assertEquals(expected, actual);
    }
}