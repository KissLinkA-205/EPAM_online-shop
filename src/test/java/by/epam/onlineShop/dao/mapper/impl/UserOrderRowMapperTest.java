package by.epam.onlineShop.dao.mapper.impl;

import by.epam.onlineShop.dao.mapper.Column;
import by.epam.onlineShop.entity.UserOrder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserOrderRowMapperTest {
    private static final long EXPECTED_LONG = 1L;
    private static final String EXPECTED_STRING = "test";
    private static final Date EXPECTED_DATE = new Date();

    @Test
    void testMap_ShouldReturnUserOrder_WhenDataIsCorrect() throws SQLException {
        java.sql.Date sqlDate = new java.sql.Date(EXPECTED_DATE.getTime());

        ResultSet rsMock = Mockito.mock(ResultSet.class);
        Mockito.when(rsMock.getLong(Column.ID)).thenReturn(EXPECTED_LONG);
        Mockito.when(rsMock.getString(Column.USER_ORDER_ADDRESS)).thenReturn(EXPECTED_STRING);
        Mockito.when(rsMock.getDate(Column.USER_ORDER_DATE)).thenReturn(sqlDate);
        Mockito.when(rsMock.getDate(Column.USER_ORDER_DELIVERY_DATE)).thenReturn(sqlDate);
        Mockito.when(rsMock.getString(Column.USER_ORDER_STATUS)).thenReturn(EXPECTED_STRING);

        UserOrderRowMapper userOrderRowMapper = new UserOrderRowMapper();
        UserOrder actual = userOrderRowMapper.map(rsMock);

        UserOrder expected = new UserOrder();
        expected.setId(EXPECTED_LONG);
        expected.setAddress(EXPECTED_STRING);
        expected.setOrderDate(sqlDate);
        expected.setDeliveryDate(sqlDate);
        expected.setStatus(EXPECTED_STRING);

        assertEquals(expected, actual);
    }
}