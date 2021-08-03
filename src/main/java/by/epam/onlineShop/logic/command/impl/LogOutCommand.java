package by.epam.onlineShop.logic.command.impl;

import by.epam.onlineShop.context.RequestContext;
import by.epam.onlineShop.context.RequestContextHelper;
import by.epam.onlineShop.logic.command.Command;
import by.epam.onlineShop.logic.command.CommandResult;
import by.epam.onlineShop.logic.command.CommandResultType;

import javax.servlet.http.HttpServletResponse;

public class LogOutCommand implements Command {
    private static final String USER = "user";
    private static final String ROLE = "role";
    private static final String LOGIN_PAGE = "WEB-INF/view/login.jsp";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext context=helper.createContext();
        context.removeSessionAttribute(USER);
        context.removeSessionAttribute(ROLE);
        helper.updateRequest(context);
        return new CommandResult(LOGIN_PAGE, CommandResultType.FORWARD);
    }
}