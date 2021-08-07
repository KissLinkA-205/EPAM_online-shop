package by.epam.onlineShop.controller.command.impl;

import by.epam.onlineShop.controller.command.Command;
import by.epam.onlineShop.controller.command.CommandResult;
import by.epam.onlineShop.controller.command.CommandResultType;
import by.epam.onlineShop.controller.context.RequestContext;
import by.epam.onlineShop.controller.context.RequestContextHelper;
import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.entity.User;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.service.OrderService;
import by.epam.onlineShop.service.ServiceFactory;
import by.epam.onlineShop.service.UserOrderService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

public class ConfirmOrderCommand implements Command {
    private static final String MY_ORDERS_PAGE = "WEB-INF/view/myOrders.jsp";
    private static final String ADD_ORDER_PAGE = "WEB-INF/view/addOrder.jsp";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final String ADDRESS = "address";
    private static final String DELIVERY_DATE = "delivery-date";
    private static final String CARDHOLDER_NAME = "cardholder-name";
    private static final String CVV = "cvv";
    private static final String CARD_NUMBER = "card-number";
    private static final String MONTH = "month";
    private static final String YEAR = "year";
    private static final String USER = "user";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        Optional<String> address = Optional.ofNullable(requestContext.getRequestParameter(ADDRESS));
        Optional<String> deliveryDate = Optional.ofNullable(requestContext.getRequestParameter(DELIVERY_DATE));
        Optional<String> cardholderName = Optional.ofNullable(requestContext.getRequestParameter(CARDHOLDER_NAME));
        Optional<String> cvv = Optional.ofNullable(requestContext.getRequestParameter(CVV));
        Optional<String> cardNumber = Optional.ofNullable(requestContext.getRequestParameter(CARD_NUMBER));
        Optional<String> month = Optional.ofNullable(requestContext.getRequestParameter(MONTH));
        Optional<String> year = Optional.ofNullable(requestContext.getRequestParameter(YEAR));

        try {
            if (isPresent(address, deliveryDate, cardholderName, cvv, cardNumber, month, year)) {
                User user = (User) requestContext.getSessionAttribute(USER);
                long userId = user.getId();
                OrderService orderService = ServiceFactory.getInstance().getOrderService();
                List<Order> orders = orderService.retrieveOrdersByUserWithoutUserOrder(userId);

                UserOrderService userOrderService = ServiceFactory.getInstance().getUserOrderService();
                boolean result = userOrderService.addNewUserOrder(orders, address.get(), deliveryDate.get());
                if (result) {
                    helper.updateRequest(requestContext);
                    return new CommandResult(MY_ORDERS_PAGE, CommandResultType.FORWARD);
                }
            }
        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }
        requestContext.addRequestAttribute(ERROR_MESSAGE, true);
        helper.updateRequest(requestContext);
        return new CommandResult(ADD_ORDER_PAGE, CommandResultType.FORWARD);
    }

    public boolean isPresent
            (Optional<String> address, Optional<String> deliveryDate, Optional<String> cardholderName,
             Optional<String> cvv, Optional<String> cardNumber, Optional<String> month, Optional<String> year) {
        return address.isPresent() && deliveryDate.isPresent() && cardholderName.isPresent() && cvv.isPresent()
                && cardNumber.isPresent() && month.isPresent();
    }
}
