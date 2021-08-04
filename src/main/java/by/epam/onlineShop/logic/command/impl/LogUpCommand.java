package by.epam.onlineShop.logic.command.impl;

import by.epam.onlineShop.context.RequestContext;
import by.epam.onlineShop.context.RequestContextHelper;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.logic.command.Command;
import by.epam.onlineShop.logic.command.CommandResult;
import by.epam.onlineShop.logic.command.CommandResultType;
import by.epam.onlineShop.logic.service.LogUpService;
import by.epam.onlineShop.logic.service.LoginService;
import org.apache.commons.codec.digest.DigestUtils;

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
    private static final String MESSAGE = "message";

    private LogUpService logUpService;

    public LogUpCommand(LogUpService logUpService) {
        this.logUpService = logUpService;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException {
        RequestContext context = helper.createContext();
        String message = "error";

        Optional<String> email = Optional.ofNullable(context.getRequestParameter(EMAIL));
        Optional<String> passwordFirst = Optional.ofNullable(context.getRequestParameter(PASSWORD_FIRST));
        Optional<String> passwordSecond = Optional.ofNullable(context.getRequestParameter(PASSWORD_SECOND));
        Optional<String> name = Optional.ofNullable(context.getRequestParameter(NAME));
        Optional<String> surname = Optional.ofNullable(context.getRequestParameter(SURNAME));
        Optional<String> patronymic = Optional.ofNullable(context.getRequestParameter(PATRONYMIC));
        Optional<String> phone = Optional.ofNullable(context.getRequestParameter(PHONE));

        if (email.isPresent() && passwordFirst.isPresent() && passwordSecond.isPresent() &&
                name.isPresent() && surname.isPresent() && patronymic.isPresent() && phone.isPresent()) {
            if (passwordFirst.get().equals(passwordSecond.get())) {
                boolean result = logUpService.register(name.get(), surname.get(), patronymic.get(), email.get(), phone.get(), DigestUtils.sha1Hex(passwordFirst.get()));
                if (result) message = "ok";
            }
        }
        context.addRequestAttribute(MESSAGE, message);

        helper.updateRequest(context);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
