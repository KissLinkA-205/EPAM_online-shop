package by.epam.onlineShop.logic.command.impl;

import by.epam.onlineShop.context.RequestContext;
import by.epam.onlineShop.context.RequestContextHelper;
import by.epam.onlineShop.entity.Promotion;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.logic.command.Command;
import by.epam.onlineShop.logic.command.CommandResult;
import by.epam.onlineShop.logic.command.CommandResultType;
import by.epam.onlineShop.logic.service.GoToPromotionsService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GoToPromotionsCommand implements Command {
    private static final String PAGE = "WEB-INF/view/promotions.jsp";
    private static final String PROMOTIONS = "promotions";
    private final GoToPromotionsService service;

    public GoToPromotionsCommand(GoToPromotionsService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException {
        RequestContext context = helper.createContext();
        List<Promotion> promotions = service.getPromotions();
        context.addRequestAttribute(PROMOTIONS, promotions);
        helper.updateRequest(context);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
