package by.epam.onlineShop.dao.mapper.impl;

import by.epam.onlineShop.dao.mapper.Column;
import by.epam.onlineShop.entity.Role;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoleRowMapperTest {
    private static final long EXPECTED_LONG = 1L;
    private static final String EXPECTED_STRING = "test";

    @Test
    void testMap_ShouldReturnRole_WhenDataIsCorrect() throws SQLException {
        ResultSet rsMock = Mockito.mock(ResultSet.class);
        Mockito.when(rsMock.getLong(Column.ID)).thenReturn(EXPECTED_LONG);
        Mockito.when(rsMock.getString(Column.ROLE_NAME)).thenReturn(EXPECTED_STRING);

        RoleRowMapper roleRowMapper = new RoleRowMapper();
        Role actual = roleRowMapper.map(rsMock);

        Role expected = new Role();
        expected.setId(EXPECTED_LONG);
        expected.setName(EXPECTED_STRING);

        assertEquals(expected, actual);
    }
}