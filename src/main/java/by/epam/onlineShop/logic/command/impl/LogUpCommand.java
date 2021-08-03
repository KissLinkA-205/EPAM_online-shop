package by.epam.onlineShop.logic.command.impl;

import by.epam.onlineShop.context.RequestContext;
import by.epam.onlineShop.context.RequestContextHelper;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.logic.command.Command;
import by.epam.onlineShop.logic.command.CommandResult;
import by.epam.onlineShop.logic.command.CommandResultType;
import by.epam.onlineShop.logic.service.LogUpService;
import by.epam.onlineShop.logic.service.LoginService;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LogUpCommand implements Command {
    private static final String PAGE = "WEB-INF/view/logup.jsp";
    private static final String EMAIL = "email";
    private static final String PASSWORD_FIRST = "password-first";
    private static final String PASSWORD_SECOND = "password-second";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String PATRONYMIC = "patronymic";
    private static final String PHONE = "phone";

    private LogUpService logUpService;

    public LogUpCommand(LogUpService logUpService) {
        this.logUpService = logUpService;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException {
        RequestContext context = helper.createContext();

        Optional<String> email = Optional.ofNullable(context.getRequestParameter(EMAIL));



        helper.updateRequest(context);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
