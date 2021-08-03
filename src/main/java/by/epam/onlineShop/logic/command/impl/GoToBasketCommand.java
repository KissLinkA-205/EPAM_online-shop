package by.epam.onlineShop.logic.command.impl;

import by.epam.onlineShop.context.RequestContext;
import by.epam.onlineShop.context.RequestContextHelper;
import by.epam.onlineShop.entity.Category;
import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.entity.Product;
import by.epam.onlineShop.entity.User;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.logic.command.Command;
import by.epam.onlineShop.logic.command.CommandResult;
import by.epam.onlineShop.logic.command.CommandResultType;
import by.epam.onlineShop.logic.service.BasketService;

import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class GoToBasketCommand implements Command {
    private static final String PAGE = "WEB-INF/view/basket.jsp";
    private static final String CATEGORIES = "categories";
    private static final String ORDERS = "orders";
    private static final String USER = "user";
    private static final String PRODUCTS = "products";
    private final BasketService basketService;

    public GoToBasketCommand(BasketService basketService) {
        this.basketService = basketService;
    }


    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException {
        RequestContext context = helper.createContext();
        List<Category> categories = basketService.getCategories();
        context.addRequestAttribute(CATEGORIES, categories);

        User user = (User) context.getSessionAttribute(USER);
        long userId = user.getId();
        List<Order> orders = basketService.getAllOrdersByUserId(userId);
        context.addRequestAttribute(ORDERS, orders);

        List<Product> products = new LinkedList<>();
        for (Order order : orders) {
            Optional<Product> product = basketService.getProductById(order.getProductId());
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
