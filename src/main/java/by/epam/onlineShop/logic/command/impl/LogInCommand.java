package by.epam.onlineShop.logic.command.impl;

import by.epam.onlineShop.context.RequestContext;
import by.epam.onlineShop.context.RequestContextHelper;
import by.epam.onlineShop.entity.Role;
import by.epam.onlineShop.entity.User;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.logic.command.Command;
import by.epam.onlineShop.logic.command.CommandResult;
import by.epam.onlineShop.logic.command.CommandResultType;
import by.epam.onlineShop.logic.service.LoginService;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LogInCommand implements Command {
    private static final String PASSWORD_PARAMETER = "password";
    private static final String EMAIL_PARAMETER = "email";
    private static final String USER = "user";
    private static final String ROLE = "role";
    private static final String PROFILE = "profile";
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final String COMMAND = "command";
    private static final String LOGIN_PAGE = "WEB-INF/view/login.jsp";
    private static final String PROFILE_PAGE = "command=profile";
    private LoginService loginService;

    public LogInCommand(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException {
        RequestContext requestContext = helper.createContext();
        String password = requestContext.getRequestParameter(PASSWORD_PARAMETER);
        String login = requestContext.getRequestParameter(EMAIL_PARAMETER);
        Optional<User> optionalResult = loginService.login(password, login);

        if (optionalResult.isPresent()) {
            requestContext.addSessionAttribute(USER, optionalResult.get());

            Optional<Role> role = loginService.getRoleById(optionalResult.get().getRoleId());
            role.ifPresent(value -> requestContext.addSessionAttribute(ROLE, value));

            helper.updateRequest(requestContext);
            return new CommandResult(PROFILE_PAGE, CommandResultType.REDIRECT);
        }
        requestContext.addRequestAttribute(ERROR_MESSAGE, true);
        helper.updateRequest(requestContext);
        return new CommandResult(LOGIN_PAGE, CommandResultType.FORWARD);
    }
}