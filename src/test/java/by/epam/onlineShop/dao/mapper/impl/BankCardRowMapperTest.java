package by.epam.onlineShop.dao.mapper.impl;

import by.epam.onlineShop.dao.mapper.Column;
import by.epam.onlineShop.entity.BankCard;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankCardRowMapperTest {
    private static final long EXPECTED_LONG = 1L;
    private static final String EXPECTED_STRING = "test";
    private static final int EXPECTED_INT = 1;
    private static final double EXPECTED_DOUBLE = 1.00;

    @Test
    void testMap_ShouldReturnBankCard_WhenDataIsCorrect() throws SQLException {
        ResultSet rsMock = Mockito.mock(ResultSet.class);
        Mockito.when(rsMock.getLong(Column.ID)).thenReturn(EXPECTED_LONG);
        Mockito.when(rsMock.getLong(Column.BANK_CARD_NUMBER)).thenReturn(EXPECTED_LONG);
        Mockito.when(rsMock.getString(Column.BANK_CARD_OWNER)).thenReturn(EXPECTED_STRING);
        Mockito.when(rsMock.getInt(Column.BANK_CARD_EXPIRATION_MONTH)).thenReturn(EXPECTED_INT);
        Mockito.when(rsMock.getInt(Column.BANK_CARD_EXPIRATION_YEAR)).thenReturn(EXPECTED_INT);
        Mockito.when(rsMock.getDouble(Column.BANK_CARD_BALANCE)).thenReturn(EXPECTED_DOUBLE);
        Mockito.when(rsMock.getInt(Column.BANK_CARD_CVV)).thenReturn(EXPECTED_INT);

        BankCardRowMapper bankCardRowMapper = new BankCardRowMapper();
        BankCard actual = bankCardRowMapper.map(rsMock);

        BankCard expected = new BankCard();
        expected.setId(EXPECTED_LONG);
        expected.setCardNumber(EXPECTED_LONG);
        expected.setCardholderName(EXPECTED_STRING);
        expected.setExpirationMonth(EXPECTED_INT);
        expected.setExpirationYear(EXPECTED_INT);
        expected.setBalance(EXPECTED_DOUBLE);
        expected.setCvv(EXPECTED_INT);

        assertEquals(expected, actual);
    }
}