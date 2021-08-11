package by.epam.onlineShop.dao;

import by.epam.onlineShop.dao.impl.CategoryDaoImpl;
import by.epam.onlineShop.dao.impl.PromotionDaoImpl;
import by.epam.onlineShop.dao.impl.RoleDaoImpl;
import by.epam.onlineShop.dao.impl.UserDaoImpl;
import by.epam.onlineShop.dao.impl.OrderDaoImpl;
import by.epam.onlineShop.dao.impl.ProductDaoImpl;
import by.epam.onlineShop.dao.impl.UserInformationDaoImpl;
import by.epam.onlineShop.dao.impl.UserOrderDaoImpl;
import by.epam.onlineShop.dao.impl.BankCardDaoImpl;

public class DaoFactory {
    private final UserDao userDao = new UserDaoImpl();
    private final CategoryDaoImpl categoryDao = new CategoryDaoImpl();
    private final PromotionDaoImpl promotionDao = new PromotionDaoImpl();
    private final RoleDaoImpl roleDao = new RoleDaoImpl();
    private final UserInformationDaoImpl userInformationDao = new UserInformationDaoImpl();
    private final ProductDao productDao = new ProductDaoImpl();
    private final OrderDao orderDao = new OrderDaoImpl();
    private final UserOrderDao userOrderDao = new UserOrderDaoImpl();
    private final BankCardDao bankCardDao = new BankCardDaoImpl();

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return Holder.INSTANCE;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public CategoryDaoImpl getCategoryDao() {
        return categoryDao;
    }

    public PromotionDaoImpl getPromotionDao() {
        return promotionDao;
    }

    public RoleDaoImpl getRoleDao() {
        return roleDao;
    }

    public UserInformationDaoImpl getUserInformationDao() {
        return userInformationDao;
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public UserOrderDao getUserOrderDao() {
        return userOrderDao;
    }

    public BankCardDao getBankCardDao() {
        return bankCardDao;
    }

    private static class Holder {
        static final DaoFactory INSTANCE = new DaoFactory();
    }
}
