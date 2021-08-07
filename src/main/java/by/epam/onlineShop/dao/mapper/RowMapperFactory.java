package by.epam.onlineShop.dao.mapper;

import by.epam.onlineShop.dao.mapper.impl.*;
import by.epam.onlineShop.entity.*;

public class RowMapperFactory {
    private final RowMapper<Category> categoryRowMapper = new CategoryRowMapper();
    private final RowMapper<Order> orderRowMapper = new OrderRowMapper();
    private final RowMapper<Product> productRowMapper = new ProductRowMapper();
    private final RowMapper<Promotion> promotionRowMapper = new PromotionRowMapper();
    private final RowMapper<Role> roleRowMapper = new RoleRowMapper();
    private final RowMapper<UserInformation> userInformationRowMapper = new UserInformationRowMapper();
    private final RowMapper<UserOrder> userOrderRowMapper = new UserOrderRowMapper();
    private final RowMapper<User> userRowMapper = new UserRowMapper();

    public static RowMapperFactory getInstance() {
        return Holder.INSTANCE;
    }

    public RowMapper<Category> getCategoryRowMapper() {
        return categoryRowMapper;
    }

    public RowMapper<Order> getOrderRowMapper() {
        return orderRowMapper;
    }

    public RowMapper<Product> getProductRowMapper() {
        return productRowMapper;
    }

    public RowMapper<Promotion> getPromotionRowMapper() {
        return promotionRowMapper;
    }

    public RowMapper<Role> getRoleRowMapper() {
        return roleRowMapper;
    }

    public RowMapper<UserInformation> getUserInformationRowMapper() {
        return userInformationRowMapper;
    }

    public RowMapper<UserOrder> getUserOrderRowMapper() {
        return userOrderRowMapper;
    }

    public RowMapper<User> getUserRowMapper() {
        return userRowMapper;
    }

    private static class Holder {
        private static final RowMapperFactory INSTANCE = new RowMapperFactory();
    }
}
