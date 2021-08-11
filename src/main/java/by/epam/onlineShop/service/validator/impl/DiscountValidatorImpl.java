package by.epam.onlineShop.service.validator.impl;

import by.epam.onlineShop.service.validator.AbstractValidator;

public class DiscountValidatorImpl extends AbstractValidator {
    private static final String DISCOUNT_REGEX = "^[0-9][0-9]?$|^100$";

    @Override
    protected String getRegex() {
        return DISCOUNT_REGEX;
    }
}
