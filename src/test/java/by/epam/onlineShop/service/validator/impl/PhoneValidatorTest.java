package by.epam.onlineShop.service.validator.impl;

import by.epam.onlineShop.service.validator.AbstractValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PhoneValidatorTest {
    private final AbstractValidator validator = new PhoneValidatorImpl();
    private static final String CORRECT_PHONE = "375291234567";
    private static final String INCORRECT_PHONE = "37529";

    @Test
    public void testPhoneValidator_ShouldReturnTrue_WhenDataIsCorrect() {
        boolean actual = validator.isValid(CORRECT_PHONE);
        assertTrue(actual);
    }

    @Test
    public void testPhoneValidator_ShouldReturnFalse_WhenDataIsNotCorrect() {
        boolean actual = validator.isValid(INCORRECT_PHONE);
        assertFalse(actual);
    }
}