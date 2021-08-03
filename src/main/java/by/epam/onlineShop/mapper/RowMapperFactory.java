package by.epam.onlineShop.mapper;

import by.epam.onlineShop.entity.Promotion;
import by.epam.onlineShop.logic.command.Command;
import by.epam.onlineShop.logic.command.impl.GoToMainCommand;

public class RowMapperFactory {
    private static final String PROMOTIONS = "Promotions";
    private static final String USERS = "Users";
    private static final String CATEGORIES = "Categories";
    private static final String USER_ORDERS = "UserOrders";
    private static final String ORDERS = "Orders";
    private static final String PRODUCTS = "Products";
    private static final String ERROR = "error";
    private static final String USER_INFORMATION = "UserInformation";
    private static final String ROLES = "Roles";

    public static RowMapper createMapper(String table) {
        switch (table) {
            case PROMOTIONS:
                return new PromotionRowMapper();
            case USERS:
                return new UserRowMapper();
            case CATEGORIES:
                return new CategoryRowMapper();
            case USER_ORDERS:
                return new UserOrderRowMapper();
            case ORDERS:
                return new OrderRowMapper();
            case PRODUCTS:
                return new ProductRowMapper();
            case USER_INFORMATION:
                return new UserInformationRowMapper();
            case ROLES:
                return new RoleRowMapper();
            default:
                throw new IllegalArgumentException(ERROR);
        }
    }
}
