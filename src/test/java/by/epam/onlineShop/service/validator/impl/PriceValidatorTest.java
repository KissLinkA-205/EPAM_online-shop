package by.epam.onlineShop.service.validator.impl;

import by.epam.onlineShop.service.validator.AbstractValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PriceValidatorTest {
    private final AbstractValidator validator = new PriceValidatorImpl();
    private static final String CORRECT_PRICE = "12.34";
    private static final String INCORRECT_PRICE = "1234";

    @Test
    public void testPriceValidator_ShouldReturnTrue_WhenDataIsCorrect() {
        boolean actual = validator.isValid(CORRECT_PRICE);
        assertTrue(actual);
    }

    @Test
    public void testPriceValidator_ShouldReturnFalse_WhenDataIsNotCorrect() {
        boolean actual = validator.isValid(INCORRECT_PRICE);
        assertFalse(actual);
    }
}