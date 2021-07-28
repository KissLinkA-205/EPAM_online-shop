package by.epam.onlineShop.logic.command;

import by.epam.onlineShop.dao.helper.DaoHelperFactory;
import by.epam.onlineShop.logic.command.impl.*;
import by.epam.onlineShop.logic.service.GoToContactsService;
import by.epam.onlineShop.logic.service.GoToMainService;
import by.epam.onlineShop.logic.service.GoToPromotionsService;
import by.epam.onlineShop.logic.service.LoginService;

public class CommandFactory {
    private static final String MAIN = "main";
    private static final String LANGUAGE = "language";
    private static final String PROFILE = "profile";
    private static final String REGISTRATION = "registration";
    private static final String LOG_IN = "login";
    private static final String ERROR = "illegal Command";
    private static final String CONTACTS = "contacts";
    private static final String CATALOG = "catalog";
    private static final String PROMOTIONS = "promotions";
    private static final String CHECK_LOGIN = "checkLogin";
    private static final String LOG_OUT = "logOut";

    public static Command createCommand(String command) {
        switch (command) {
            case MAIN:
                return new GoToMainCommand(new GoToMainService(new DaoHelperFactory()));
            case LANGUAGE:
                return new LanguageCommand();
            case PROFILE:
                return new GoToProfileCommand();
            case REGISTRATION:
                return new GoToRegistrationCommand();
            case LOG_IN:
                return new GoToLoginCommand();
            case CONTACTS:
                return new GoToContactsCommand(new GoToContactsService(new DaoHelperFactory()));
            case PROMOTIONS:
                return new GoToPromotionsCommand(new GoToPromotionsService(new DaoHelperFactory()));
            case CATALOG:
                return new GoToCatalogCommand();
            case CHECK_LOGIN:
                return new LogInCommand(new LoginService(new DaoHelperFactory()));
            case LOG_OUT:
                return new LogOutCommand();
            default:
                throw new IllegalArgumentException(ERROR);
        }
    }
}
