package by.epam.onlineShop.logic.command.impl;

import by.epam.onlineShop.context.RequestContext;
import by.epam.onlineShop.context.RequestContextHelper;
import by.epam.onlineShop.entity.Category;
import by.epam.onlineShop.entity.Product;
import by.epam.onlineShop.entity.Promotion;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.logic.command.Command;
import by.epam.onlineShop.logic.command.CommandResult;
import by.epam.onlineShop.logic.command.CommandResultType;
import by.epam.onlineShop.logic.service.CatalogService;
import by.epam.onlineShop.logic.service.PromotionsService;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GoToCatalogCommand implements Command {
    private static final String PAGE = "WEB-INF/view/catalog.jsp";
    private static final String CATEGORY_ID = "categoryId";
    private static final String CATEGORIES = "categories";
    private static final String PRODUCTS = "products";
    private static final String NEW_PRICES = "newPrices";
    private final CatalogService catalogService;

    public GoToCatalogCommand(CatalogService catalogService) {
        this.catalogService = catalogService;
    }


    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException {
        RequestContext context = helper.createContext();

        List<Category> categories = catalogService.getCategories();
        context.addRequestAttribute(CATEGORIES, categories);
        long categoryId = Long.parseLong(context.getRequestParameter(CATEGORY_ID));
        List<Product> products = catalogService.getProducts(categoryId);
        context.addRequestAttribute(PRODUCTS, products);

        Map<String, Double> newPrices = new HashMap<>();

        for (Product product : products) {
            if (product.getPromotionId() != 0) {
                Optional<Promotion> promotion = catalogService.getPromotionById(product.getPromotionId());
                if (promotion.isPresent()) {
                    Double newPrice = catalogService.calculateNewPrice(product.getPrice(), promotion.get().getDiscount());
                    newPrices.put(product.getName(), newPrice);
                }
            }
        }
        context.addRequestAttribute(NEW_PRICES, newPrices);

        helper.updateRequest(context);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
