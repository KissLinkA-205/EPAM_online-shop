package by.epam.onlineShop.logic.validator;

import by.epam.onlineShop.dao.promotionDao.PromotionDaoImpl;

public class ValidatorHelper {

    private static class  ValidatorHelperHolder {
        public static final ValidatorHelper HOLDER_INSTANCE = new ValidatorHelper();
    }

    public static ValidatorHelper getInstance() {
        return ValidatorHelperHolder.HOLDER_INSTANCE;
    }

    public NameValidator createNameValidator() {
        return new NameValidator();
    }

    public EmailValidator createEmailValidator() {
        return new EmailValidator();
    }

    public PhoneValidator createPhoneValidator() {
        return new PhoneValidator();
    }
}
