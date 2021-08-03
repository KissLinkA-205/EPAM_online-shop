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

public class GoToViewOrdersCommand implements Command {
    private static final String CATEGORIES = "categories";
    private static final String USER_ORDERS = "userOrders";
    private static final String USERS = "users";
    private static final String PRODUCTS = "products";
    private static final String ORDERS = "orders";
    private static final String USER_INFORMATION = "userInformation";
    private static final String PAGE = "WEB-INF/view/viewOrders.jsp";
    private final OrdersService ordersService;

    public GoToViewOrdersCommand(OrdersService ordersService) {
        this.ordersService = ordersService;
    }


    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException {
        RequestContext context = helper.createContext();

        List<Category> categories = ordersService.getCategories();
        context.addRequestAttribute(CATEGORIES, categories);

        List<UserOrder> userOrders = ordersService.getAllUserOrdersByStatus("expected");
        context.addRequestAttribute(USER_ORDERS, userOrders);

        List<Order> orders = new LinkedList<>();
        for (UserOrder userOrder : userOrders) {
            List<Order> order = ordersService.getAllOrdersByUserOrderId(userOrder.getId());
            if (!order.isEmpty()) {
                orders.addAll(order);
            }
        }
        context.addRequestAttribute(ORDERS, orders);

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

        List<User> users = new LinkedList<>();
        for (Order order : orders) {
            Optional<User> user = ordersService.getUserById(order.getUserId());
            if (user.isPresent()) {
                if (!users.contains(user.get())) {
                    users.add(user.get());
                }
            }
        }
        context.addRequestAttribute(USERS, users);

        List<UserInformation> userInformation = new LinkedList<>();
        for (User user : users) {
            Optional<UserInformation> information = ordersService.getUserInformationById(user.getUserInformationId());
            if (information.isPresent()) {
                if (!userInformation.contains(information.get())) {
                    userInformation.add(information.get());
                }
            }
        }
        context.addRequestAttribute(USER_INFORMATION, userInformation);

        helper.updateRequest(context);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
