package by.epam.onlineShop.service;

import by.epam.onlineShop.entity.Category;
import by.epam.onlineShop.exeptions.ServiceException;

import java.util.List;

public interface CategoryService {

    /**
     * Method to retrieve categories
     *
     * @return List of categories
     * @throws ServiceException
     */
    List<Category> retrieveCategories() throws ServiceException;
}
