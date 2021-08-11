package by.epam.onlineShop.controller.command.impl.transition;

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

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GoToAddOrderCommand implements Command {
    private static final String PAGE = "WEB-INF/view/addOrder.jsp";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String USER = "user";
    private static final String TOTAL_COST = "totalCost";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        User user = (User) requestContext.getSessionAttribute(USER);
        long userId = user.getId();

        try {
            OrderService orderService = ServiceFactory.getInstance().getOrderService();
            List<Order> orders = orderService.retrieveOrdersByUserWhereProductStatusTrue(userId);

            double totalPrice = orderService.calculateTotalCost(orders);
            requestContext.addRequestAttribute(TOTAL_COST, totalPrice);
        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }
        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}