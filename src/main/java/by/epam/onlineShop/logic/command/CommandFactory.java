package by.epam.onlineShop.logic.command;

import by.epam.onlineShop.dao.helper.DaoHelperFactory;
import by.epam.onlineShop.logic.command.impl.*;
import by.epam.onlineShop.logic.service.*;

public class CommandFactory {
    private static final String MAIN = "main";
    private static final String PROFILE = "profile";
    private static final String REGISTRATION = "registration";
    private static final String LOG_IN = "login";
    private static final String ERROR = "illegal Command";
    private static final String CONTACTS = "contacts";
    private static final String CATALOG = "catalog";
    private static final String PROMOTIONS = "promotions";
    private static final String CHECK_LOGIN = "checkLogin";
    private static final String LOG_OUT = "logOut";
    private static final String LOG_UP = "logUp";
    private static final String MY_ORDERS = "myOrders";
    private static final String BASKET = "basket";
    private static final String ADD_PRODUCT = "addProduct";
    private static final String ADD_PROMOTION = "addPromotion";
    private static final String VIEW_ORDERS = "viewOrders";

    public static Command createCommand(String command) {
        switch (command) {
            case MAIN:
                return new GoToMainCommand(new MainService(new DaoHelperFactory()));
            case PROFILE:
                return new GoToProfileCommand(new ProfileService(new DaoHelperFactory()));
            case REGISTRATION:
                return new LogUpCommand(new LogUpService(new DaoHelperFactory()));
            case LOG_IN:
                return new GoToLoginCommand();
            case CONTACTS:
                return new GoToContactsCommand(new ContactsService(new DaoHelperFactory()));
            case PROMOTIONS:
                return new GoToPromotionsCommand(new PromotionsService(new DaoHelperFactory()));
            case CATALOG:
                return new GoToCatalogCommand(new CatalogService(new DaoHelperFactory()));
            case CHECK_LOGIN:
                return new LogInCommand(new LoginService(new DaoHelperFactory()));
            case LOG_OUT:
                return new LogOutCommand();
            case LOG_UP:
                return new GoToLogUpCommand();
            case MY_ORDERS:
                return new GoToMyOrdersCommand(new OrdersService(new DaoHelperFactory()));
            case BASKET:
                return new GoToBasketCommand(new BasketService(new DaoHelperFactory()));
            case VIEW_ORDERS:
                return new GoToViewOrdersCommand(new OrdersService(new DaoHelperFactory()));
            case ADD_PRODUCT:
                return new GoToAddProductCommand();
            case ADD_PROMOTION:
                return new GoToAddPromotionCommand();
            default:
                throw new IllegalArgumentException(ERROR);
        }
    }
}
