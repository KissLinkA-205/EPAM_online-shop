package by.epam.onlineShop.service.validator;

import by.epam.onlineShop.service.validator.impl.*;

public class ValidatorFactory {
    private final CardNumberValidatorImpl cardNumberValidator = new CardNumberValidatorImpl();
    private final CvvValidatorImpl cvvValidator = new CvvValidatorImpl();
    private final EmailValidatorImpl emailValidator = new EmailValidatorImpl();
    private final MonthValidatorImpl monthValidator = new MonthValidatorImpl();
    private final NameValidatorImpl nameValidator = new NameValidatorImpl();
    private final PhoneValidatorImpl phoneValidator = new PhoneValidatorImpl();
    private final YearValidatorImpl yearValidator = new YearValidatorImpl();

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

    private static class Holder {
        static final ValidatorFactory INSTANCE = new ValidatorFactory();
    }
}
