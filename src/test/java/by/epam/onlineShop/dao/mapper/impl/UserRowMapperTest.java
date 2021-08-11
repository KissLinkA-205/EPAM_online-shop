package by.epam.onlineShop.dao.mapper.impl;

import by.epam.onlineShop.dao.mapper.Column;
import by.epam.onlineShop.entity.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserRowMapperTest {
    private static final long EXPECTED_LONG = 1L;
    private static final String EXPECTED_STRING = "test";

    @Test
    void testMap_ShouldReturnUser_WhenDataIsCorrect() throws SQLException {
        ResultSet rsMock = Mockito.mock(ResultSet.class);
        Mockito.when(rsMock.getLong(Column.ID)).thenReturn(EXPECTED_LONG);
        Mockito.when(rsMock.getLong(Column.USER_INFORMATION_ID)).thenReturn(EXPECTED_LONG);
        Mockito.when(rsMock.getLong(Column.ROLE_ID)).thenReturn(EXPECTED_LONG);
        Mockito.when(rsMock.getString(Column.USER_EMAIL)).thenReturn(EXPECTED_STRING);
        Mockito.when(rsMock.getString(Column.USER_PASSWORD)).thenReturn(EXPECTED_STRING);

        UserRowMapper userRowMapper = new UserRowMapper();
        User actual = userRowMapper.map(rsMock);

        User expected = new User();
        expected.setId(EXPECTED_LONG);
        expected.setUserInformationId(EXPECTED_LONG);
        expected.setRoleId(EXPECTED_LONG);
        expected.setEmail(EXPECTED_STRING);
        expected.setPassword(EXPECTED_STRING);

        assertEquals(expected, actual);
    }
}