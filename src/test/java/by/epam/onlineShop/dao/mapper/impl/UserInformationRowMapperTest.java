package by.epam.onlineShop.dao.mapper.impl;

import by.epam.onlineShop.dao.mapper.Column;
import by.epam.onlineShop.entity.UserInformation;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserInformationRowMapperTest {
    private static final long EXPECTED_LONG = 1L;
    private static final String EXPECTED_STRING = "test";

    @Test
    void testMap_ShouldReturnUserInformation_WhenDataIsCorrect() throws SQLException {
        ResultSet rsMock = Mockito.mock(ResultSet.class);
        Mockito.when(rsMock.getLong(Column.ID)).thenReturn(EXPECTED_LONG);
        Mockito.when(rsMock.getString(Column.USER_INFORMATION_NAME)).thenReturn(EXPECTED_STRING);
        Mockito.when(rsMock.getString(Column.USER_INFORMATION_SURNAME)).thenReturn(EXPECTED_STRING);
        Mockito.when(rsMock.getString(Column.USER_INFORMATION_PATRONYMIC)).thenReturn(EXPECTED_STRING);
        Mockito.when(rsMock.getLong(Column.USER_INFORMATION_PHONE)).thenReturn(EXPECTED_LONG);

        UserInformationRowMapper userInformationRowMapper = new UserInformationRowMapper();
        UserInformation actual = userInformationRowMapper.map(rsMock);

        UserInformation expected = new UserInformation();
        expected.setId(EXPECTED_LONG);
        expected.setName(EXPECTED_STRING);
        expected.setSurname(EXPECTED_STRING);
        expected.setPatronymic(EXPECTED_STRING);
        expected.setPhone(EXPECTED_LONG);

        assertEquals(expected, actual);
    }
}