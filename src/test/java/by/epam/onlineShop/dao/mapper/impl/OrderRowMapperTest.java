package by.epam.onlineShop.dao.mapper.impl;

import by.epam.onlineShop.dao.mapper.Column;
import by.epam.onlineShop.entity.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderRowMapperTest {
    private static final long EXPECTED_LONG = 1L;
    private static final int EXPECTED_INT = 1;

    @Test
    void testMap_ShouldReturnOrder_WhenDataIsCorrect() throws SQLException {
        ResultSet rsMock = Mockito.mock(ResultSet.class);
        Mockito.when(rsMock.getLong(Column.ID)).thenReturn(EXPECTED_LONG);
        Mockito.when(rsMock.getLong(Column.USER_ID)).thenReturn(EXPECTED_LONG);
        Mockito.when(rsMock.getLong(Column.USER_ORDER_ID)).thenReturn(EXPECTED_LONG);
        Mockito.when(rsMock.getLong(Column.PRODUCT_ID)).thenReturn(EXPECTED_LONG);
        Mockito.when(rsMock.getInt(Column.ORDER_NUMBER)).thenReturn(EXPECTED_INT);

        OrderRowMapper orderRowMapper = new OrderRowMapper();
        Order actual = orderRowMapper.map(rsMock);

        Order expected = new Order();
        expected.setId(EXPECTED_LONG);
        expected.setUserId(EXPECTED_LONG);
        expected.setUserOrderId(EXPECTED_LONG);
        expected.setProductId(EXPECTED_LONG);
        expected.setNumber(EXPECTED_INT);

        assertEquals(expected, actual);
    }
}