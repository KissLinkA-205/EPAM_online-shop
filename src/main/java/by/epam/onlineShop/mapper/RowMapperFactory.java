package by.epam.onlineShop.mapper;

import by.epam.onlineShop.entity.Promotion;
import by.epam.onlineShop.logic.command.Command;
import by.epam.onlineShop.logic.command.impl.GoToMainCommand;

public class RowMapperFactory {
    private static final String PROMOTIONS = "Promotions";
    private static final String USERS = "Users";
    private static final String CATEGORIES = "Categories";
    private static final String ERROR = "error";

    public static RowMapper createMapper(String table) {
        switch (table) {
            case PROMOTIONS:
                return new PromotionRowMapper();
            case USERS:
                return new UserRowMapper();
            case CATEGORIES:
                return new CategoryRowMapper();
            default:
                System.out.println("new IllegalArgumentException(ERROR)");
                throw new IllegalArgumentException(ERROR);
        }
    }
}
