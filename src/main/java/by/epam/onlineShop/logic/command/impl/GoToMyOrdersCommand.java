package by.epam.onlineShop.logic.command.impl;

import by.epam.onlineShop.context.RequestContext;
import by.epam.onlineShop.context.RequestContextHelper;
import by.epam.onlineShop.entity.*;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.logic.command.Command;
import by.epam.onlineShop.logic.command.CommandResult;
import by.epam.onlineShop.logic.command.CommandResultType;
import by.epam.onlineShop.logic.service.OrdersService;

import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class GoToMyOrdersCommand implements Command {
    private static final String PAGE = "WEB-INF/view/myOrders.jsp";
    private static final String USER_ORDERS = "userOrders";
    private static final String ORDERS = "orders";
    private static final String PRODUCTS = "products";
    private static final String CATEGORIES = "categories";
    private static final String USER = "user";
    private final OrdersService ordersService;

    public GoToMyOrdersCommand(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException {
        RequestContext context = helper.createContext();
        List<Category> categories = ordersService.getCategories();
        context.addRequestAttribute(CATEGORIES, categories);

        User user = (User) context.getSessionAttribute(USER);
        long userId = user.getId();
        List<Order> orders = ordersService.getAllOrdersByUserId(userId);
        context.addRequestAttribute(ORDERS, orders);

        List<UserOrder> userOrders = new LinkedList<>();
        for (Order order : orders) {
            Optional<UserOrder> userOrder = ordersService.getUserOrderById(order.getUserOrderId());
            if (userOrder.isPresent()) {
                boolean checkIfOrderExistFlag = false;
                for (UserOrder value : userOrders) {
                    if (value.getId() == userOrder.get().getId()) {
                        checkIfOrderExistFlag = true;
                    }
                }
                if (!checkIfOrderExistFlag) {
                    userOrders.add(userOrder.get());
                }
            }
        }

        context.addRequestAttribute(USER_ORDERS, userOrders);

        List<Product> products = new LinkedList<>();
        for (Order order : orders) {
            Optional<Product> product = ordersService.getProductById(order.getProductId());
            if (product.isPresent()) {
                if (!products.contains(product.get())) {
                    products.add(product.get());
                }
            }
        }
        context.addRequestAttribute(PRODUCTS, products);

        helper.updateRequest(context);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
