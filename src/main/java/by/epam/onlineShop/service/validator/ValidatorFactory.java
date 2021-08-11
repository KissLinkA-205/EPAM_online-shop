package by.epam.onlineShop.service.validator;

import by.epam.onlineShop.service.validator.impl.CardNumberValidatorImpl;
import by.epam.onlineShop.service.validator.impl.CvvValidatorImpl;
import by.epam.onlineShop.service.validator.impl.EmailValidatorImpl;
import by.epam.onlineShop.service.validator.impl.MonthValidatorImpl;
import by.epam.onlineShop.service.validator.impl.NameValidatorImpl;
import by.epam.onlineShop.service.validator.impl.PhoneValidatorImpl;
import by.epam.onlineShop.service.validator.impl.PriceValidatorImpl;
import by.epam.onlineShop.service.validator.impl.YearValidatorImpl;
import by.epam.onlineShop.service.validator.impl.DiscountValidatorImpl;
import by.epam.onlineShop.service.validator.impl.IdValidatorImpl;

public class ValidatorFactory {
    private final CardNumberValidatorImpl cardNumberValidator = new CardNumberValidatorImpl();
    private final CvvValidatorImpl cvvValidator = new CvvValidatorImpl();
    private final EmailValidatorImpl emailValidator = new EmailValidatorImpl();
    private final MonthValidatorImpl monthValidator = new MonthValidatorImpl();
    private final NameValidatorImpl nameValidator = new NameValidatorImpl();
    private final PhoneValidatorImpl phoneValidator = new PhoneValidatorImpl();
    private final YearValidatorImpl yearValidator = new YearValidatorImpl();
    private final PriceValidatorImpl priceValidator = new PriceValidatorImpl();
    private final IdValidatorImpl idValidator = new IdValidatorImpl();
    private final DiscountValidatorImpl discountValidator = new DiscountValidatorImpl();

    public static ValidatorFactory getInstance() {
        return Holder.INSTANCE;
    }

    public CardNumberValidatorImpl getCardNumberValidator() {
        return cardNumberValidator;
    }

    public CvvValidatorImpl getCvvValidator() {
        return cvvValidator;
    }

    public EmailValidatorImpl getEmailValidator() {
        return emailValidator;
    }

    public MonthValidatorImpl getMonthValidator() {
        return monthValidator;
    }

    public NameValidatorImpl getNameValidator() {
        return nameValidator;
    }

    public PhoneValidatorImpl getPhoneValidator() {
        return phoneValidator;
    }

    public YearValidatorImpl getYearValidator() {
        return yearValidator;
    }

    public PriceValidatorImpl getPriceValidator() {
        return priceValidator;
    }

    public IdValidatorImpl getIdValidator() {
        return idValidator;
    }

    public DiscountValidatorImpl getDiscountValidator() {
        return discountValidator;
    }

    private static class Holder {
        static final ValidatorFactory INSTANCE = new ValidatorFactory();
    }
}
