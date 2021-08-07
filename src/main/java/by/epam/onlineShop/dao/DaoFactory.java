package by.epam.onlineShop.dao;

import by.epam.onlineShop.dao.impl.*;

public class DaoFactory {
    private final UserDao userDao = new UserDaoImpl();
    private final CategoryDaoImpl categoryDao = new CategoryDaoImpl();
    private final PromotionDaoImpl promotionDao = new PromotionDaoImpl();
    private final RoleDaoImpl roleDao = new RoleDaoImpl();
    private final UserInformationDaoImpl userInformationDao = new UserInformationDaoImpl();

    private DaoFactory() { }

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

    private static class Holder {
        static final DaoFactory INSTANCE = new DaoFactory();
    }
}
