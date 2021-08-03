package by.epam.onlineShop.logic.command.impl;

import by.epam.onlineShop.context.RequestContext;
import by.epam.onlineShop.context.RequestContextHelper;
import by.epam.onlineShop.entity.Category;
import by.epam.onlineShop.entity.Promotion;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.logic.command.Command;
import by.epam.onlineShop.logic.command.CommandResult;
import by.epam.onlineShop.logic.command.CommandResultType;
import by.epam.onlineShop.logic.service.MainService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GoToMainCommand implements Command {
    private static final String PAGE = "WEB-INF/view/main.jsp";
    private final MainService mainService;
    private static final String PROMOTIONS = "promotions";
    private static final String CATEGORIES = "categories";

    public GoToMainCommand(MainService mainService) {
        this.mainService = mainService;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException {
        RequestContext requestContext = helper.createContext();
        List<Category> categories = mainService.getCategories();
        requestContext.addRequestAttribute(CATEGORIES, categories);
        List<Promotion> promotions = mainService.getPromotions();
        requestContext.addRequestAttribute(PROMOTIONS, promotions);
        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
