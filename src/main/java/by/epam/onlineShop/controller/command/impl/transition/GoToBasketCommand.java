package by.epam.onlineShop.controller.command.impl.transition;

import by.epam.onlineShop.controller.command.Command;
import by.epam.onlineShop.controller.command.CommandResult;
import by.epam.onlineShop.controller.command.CommandResultType;
import by.epam.onlineShop.controller.context.RequestContext;
import by.epam.onlineShop.controller.context.RequestContextHelper;
import by.epam.onlineShop.entity.Category;
import by.epam.onlineShop.entity.Order;
import by.epam.onlineShop.entity.Product;
import by.epam.onlineShop.entity.User;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.service.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class GoToBasketCommand implements Command {
    private static final String PAGE = "WEB-INF/view/basket.jsp";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String CATEGORIES = "categories";
    private static final String ORDERS = "orders";
    private static final String USER = "user";
    private static final String PRODUCTS = "products";
    private static final String TOTAL_COST = "totalCost";
    private static final String NEW_PRICES = "newPrices";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        User user = (User) requestContext.getSessionAttribute(USER);
        if (user == null) {
            helper.updateRequest(requestContext);
            return new CommandResult(PAGE, CommandResultType.FORWARD);
        }
        try {
            CategoryService categoryService = ServiceFactory.getInstance().getCategoryService();
            List<Category> categories = categoryService.retrieveCategories();
            requestContext.addRequestAttribute(CATEGORIES, categories);

            long userId = user.getId();
            OrderService orderService = ServiceFactory.getInstance().getOrderService();
            List<Order> orders = orderService.retrieveOrdersByUserWhereProductStatusTrue(userId);
            requestContext.addRequestAttribute(ORDERS, orders);

            double totalPrice = orderService.calculateTotalCost(orders);
            requestContext.addRequestAttribute(TOTAL_COST, totalPrice);

            ProductService productService = ServiceFactory.getInstance().getProductService();
            List<Product> products = productService.getProductsFromOrders(orders);
            requestContext.addRequestAttribute(PRODUCTS, products);

            PromotionService promotionService = ServiceFactory.getInstance().getPromotionService();
            Map<String, Double> newPrices = promotionService.getNewPrices(products);
            requestContext.addRequestAttribute(NEW_PRICES, newPrices);
        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
