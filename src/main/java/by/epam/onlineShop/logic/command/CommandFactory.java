package by.epam.onlineShop.logic.command;

import by.epam.onlineShop.logic.command.impl.*;

public class CommandFactory {
    private static final String MAIN = "main";
    private static final String LANGUAGE = "language";
    private static final String PROFILE = "profile";
    private static final String REGISTRATION = "registration";
    private static final String LOG_IN = "login";
    private static final String ERROR = "illegal Command";
    private static final String CONTACTS = "contacts";

    public static Command createCommand(String command) {
        switch (command) {
            case MAIN:
                return new GoToMainCommand();
            case LANGUAGE:
                return new LanguageCommand();
            case PROFILE:
                return new GoToProfileCommand();
            case REGISTRATION:
                return new GoToRegistrationCommand();
            case LOG_IN:
                return new GoToLoginCommand();
            case CONTACTS:
                return new GoToContactsCommand();
            default:
                throw new IllegalArgumentException(ERROR);
        }
    }
}
