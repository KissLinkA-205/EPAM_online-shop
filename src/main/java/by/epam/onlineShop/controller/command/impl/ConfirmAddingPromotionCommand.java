package by.epam.onlineShop.controller.command.impl;

import by.epam.onlineShop.controller.command.Command;
import by.epam.onlineShop.controller.command.CommandResult;
import by.epam.onlineShop.controller.command.CommandResultType;
import by.epam.onlineShop.controller.context.RequestContext;
import by.epam.onlineShop.controller.context.RequestContextHelper;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.service.PromotionService;
import by.epam.onlineShop.service.ServiceFactory;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class ConfirmAddingPromotionCommand implements Command {
    private static final String PAGE = "command=addPromotion";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String PROMOTION_NAME = "promotion-name";
    private static final String BEGINNING_DATE = "beginning-date";
    private static final String EXPIRATION_DATE = "expiration-date";
    private static final String DISCOUNT = "discount";
    private static final String PHOTO = "photo";
    private static final String DESCRIPTION = "description";
    private static final String MESSAGE_PARAMETER = "&message=";
    private static final String ERROR = "error";
    private static final String OK = "ok";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();
        String message = ERROR;

        Optional<String> promotionName = Optional.ofNullable(requestContext.getRequestParameter(PROMOTION_NAME));
        Optional<String> photo = Optional.ofNullable(requestContext.getRequestParameter(PHOTO));
        Optional<String> beginningDate = Optional.ofNullable(requestContext.getRequestParameter(BEGINNING_DATE));
        Optional<String> expirationDate = Optional.ofNullable(requestContext.getRequestParameter(EXPIRATION_DATE));
        Optional<String> description = Optional.ofNullable(requestContext.getRequestParameter(DESCRIPTION));
        Optional<String> discount = Optional.ofNullable(requestContext.getRequestParameter(DISCOUNT));

        try {
            if (promotionName.isPresent() && photo.isPresent() && beginningDate.isPresent() && expirationDate.isPresent() &&
                    description.isPresent() && discount.isPresent()) {

                PromotionService promotionService = ServiceFactory.getInstance().getPromotionService();
                boolean result = promotionService.addNewPromotion(promotionName.get(), photo.get(), beginningDate.get(),
                        expirationDate.get(), description.get(), discount.get());
                if (result) {
                    message = OK;
                }
            }
        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE + MESSAGE_PARAMETER + message, CommandResultType.REDIRECT);
    }
}
