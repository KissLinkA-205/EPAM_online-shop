package by.epam.onlineShop.service;

import by.epam.onlineShop.service.impl.*;

public class ServiceFactory {
    private final UserService userService = new UserServiceImpl();
    private final PromotionService promotionService = new PromotionServiceImpl();
    private final CategoryService categoryService = new CategoryServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();
    private final ProductService productService = new ProductServiceImpl();
    private final RoleService roleService = new RoleServiceImpl();
    private final UserInformationService userInformationService = new UserInformationServiceImpl();
    private final UserOrderService userOrderService = new UserOrderServiceImpl();

    private ServiceFactory() { }

    public static ServiceFactory getInstance() {
        return Holder.INSTANCE;
    }

    public UserService getUserService() {
        return userService;
    }

    public PromotionService getPromotionService() {
        return promotionService;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public ProductService getProductService() {
        return productService;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public UserInformationService getUserInformationService() {
        return userInformationService;
    }

    public UserOrderService getUserOrderService() {
        return userOrderService;
    }

    private static class Holder {
        static final ServiceFactory INSTANCE = new ServiceFactory();
    }
}
