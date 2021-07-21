package by.epam.onlineShop.logic.command.impl;

import by.epam.onlineShop.context.RequestContext;
import by.epam.onlineShop.context.RequestContextHelper;
import by.epam.onlineShop.logic.command.Command;
import by.epam.onlineShop.logic.command.CommandResult;
import by.epam.onlineShop.logic.command.CommandResultType;

import javax.servlet.http.HttpServletResponse;

public class LanguageCommand implements Command {
    private static final String LANGUAGE = "language";
    private static final String PATH = "path";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();
        String language = requestContext.getRequestParameter(LANGUAGE);
        requestContext.addSessionAttribute(LANGUAGE, language);
        String path = requestContext.getRequestParameter(PATH);

        helper.updateRequest(requestContext);
        return new CommandResult(path, CommandResultType.FORWARD);
    }
}
