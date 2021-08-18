package by.epam.onlineShop.dao.impl;

import by.epam.onlineShop.dao.CategoryDao;
import by.epam.onlineShop.dao.connection.ConnectionPool;
import by.epam.onlineShop.entity.Category;
import by.epam.onlineShop.exeptions.ConnectionException;
import by.epam.onlineShop.exeptions.DaoException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CategoryDaoTest {
    CategoryDao categoryDao = new CategoryDaoImpl();

    @BeforeAll
    static void initializeConnectionPool() throws ConnectionException {
        ConnectionPool.getInstance().initialize();
    }

    @Test
    public void testFindByName_ShouldReturnCategory_WhenDataIsCorrect() throws DaoException {
        Optional<Category> actual = categoryDao.findByName("Ноутбуки");
        Category expected = new Category();
        expected.setId(1);
        expected.setCategoryName("Ноутбуки");
        assertEquals(expected, actual.get());
    }

    @Test
    public void testFindById_ShouldReturnCategory_WhenDataIsCorrect() throws DaoException {
        Optional<Category> actual = categoryDao.findById(1);
        Category expected = new Category();
        expected.setId(1);
        expected.setCategoryName("Ноутбуки");
        assertEquals(expected, actual.get());
    }
}