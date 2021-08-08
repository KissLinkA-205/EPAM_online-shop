package by.epam.onlineShop.controller.command.impl;

import by.epam.onlineShop.controller.command.Command;
import by.epam.onlineShop.controller.command.CommandResult;
import by.epam.onlineShop.controller.command.CommandResultType;
import by.epam.onlineShop.controller.context.RequestContext;
import by.epam.onlineShop.controller.context.RequestContextHelper;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.service.ProductService;
import by.epam.onlineShop.service.ServiceFactory;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class ConfirmAddingProductCommand implements Command {
    private static final String PAGE = "command=addProduct";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String PRODUCT_NAME = "product-name";
    private static final String PHOTO = "photo";
    private static final String PRICE = "price";
    private static final String CATEGORY = "category";
    private static final String PROMOTION = "promotion";
    private static final String DESCRIPTION = "description";
    private static final String AVAILABILITY = "availability";
    private static final String MESSAGE_PARAMETER = "&message=";
    private static final String MESSAGE = "message";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();
        String message = "error";

        Optional<String> productName = Optional.ofNullable(requestContext.getRequestParameter(PRODUCT_NAME));
        Optional<String> photo = Optional.ofNullable(requestContext.getRequestParameter(PHOTO));
        Optional<String> price = Optional.ofNullable(requestContext.getRequestParameter(PRICE));
        Optional<String> category = Optional.ofNullable(requestContext.getRequestParameter(CATEGORY));
        Optional<String> description = Optional.ofNullable(requestContext.getRequestParameter(DESCRIPTION));
        Optional<String> availability = Optional.ofNullable(requestContext.getRequestParameter(AVAILABILITY));

        try {
            if (productName.isPresent() && photo.isPresent() && price.isPresent() && category.isPresent() &&
                    description.isPresent()) {
                boolean status = false;
                if (availability.isPresent()) {
                    status = true;
                }

                ProductService productService = ServiceFactory.getInstance().getProductService();
                boolean result = productService.addNewProduct(productName.get(),
                        photo.get(), price.get(), category.get(), status, description.get());
                if (result) {
                    message = "ok";
                }
            }
        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE + MESSAGE_PARAMETER + message, CommandResultType.REDIRECT);
    }
}
