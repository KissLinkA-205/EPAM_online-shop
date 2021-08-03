package by.epam.onlineShop.logic.command.impl;

import by.epam.onlineShop.context.RequestContext;
import by.epam.onlineShop.context.RequestContextHelper;
import by.epam.onlineShop.entity.User;
import by.epam.onlineShop.entity.UserInformation;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.logic.command.Command;
import by.epam.onlineShop.logic.command.CommandResult;
import by.epam.onlineShop.logic.command.CommandResultType;
import by.epam.onlineShop.logic.service.ProfileService;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class GoToProfileCommand implements Command {
    private static final String PAGE = "WEB-INF/view/profile.jsp";
    private static final String USER = "user";
    private static final String USER_INFORMATION = "userInformation";
    private static final String PROFILE = "profile";
    private static final String COMMAND = "command";
    private final ProfileService userInformationService;

    public GoToProfileCommand(ProfileService userInformationService) {
        this.userInformationService = userInformationService;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException {
        RequestContext context = helper.createContext();

        User user = (User) context.getSessionAttribute(USER);
        long id = user.getUserInformationId();
        Optional<UserInformation> userInformation = userInformationService.getInformation(id);
        userInformation.ifPresent(information -> context.addRequestAttribute(USER_INFORMATION, information));
        helper.updateRequest(context);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
