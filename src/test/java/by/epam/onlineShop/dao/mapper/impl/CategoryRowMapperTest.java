package by.epam.onlineShop.dao.mapper.impl;

import by.epam.onlineShop.dao.mapper.Column;
import by.epam.onlineShop.entity.Category;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CategoryRowMapperTest {

    private static final long EXPECTED_LONG = 1L;
    private static final String EXPECTED_STRING = "test";

    @Test
    void testMap_ShouldReturnCategory_WhenDataIsCorrect() throws SQLException {
        ResultSet rsMock = Mockito.mock(ResultSet.class);
        Mockito.when(rsMock.getLong(Column.ID)).thenReturn(EXPECTED_LONG);
        Mockito.when(rsMock.getString(Column.CATEGORY_NAME)).thenReturn(EXPECTED_STRING);

        CategoryRowMapper categoryRowMapper = new CategoryRowMapper();
        Category actual = categoryRowMapper.map(rsMock);

        Category expected = new Category();
        expected.setId(EXPECTED_LONG);
        expected.setCategoryName(EXPECTED_STRING);

        assertEquals(expected, actual);
    }
}