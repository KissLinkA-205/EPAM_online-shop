package by.epam.onlineShop.service.validator.impl;

import by.epam.onlineShop.service.validator.AbstractValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CvvValidatorTest {
    private final AbstractValidator validator = new CvvValidatorImpl();
    private static final String CORRECT_CVV = "123";
    private static final String INCORRECT_CVV = "1234";

    @Test
    public void testCvvValidator_ShouldReturnTrue_WhenDataIsCorrect() {
        boolean actual = validator.isValid(CORRECT_CVV);
        assertTrue(actual);
    }

    @Test
    public void testCvvValidator_ShouldReturnFalse_WhenDataIsNotCorrect() {
        boolean actual = validator.isValid(INCORRECT_CVV);
        assertFalse(actual);
    }
}