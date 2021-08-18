package by.epam.onlineShop.service.validator.impl;

import by.epam.onlineShop.service.validator.AbstractValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IdValidatorTest {
    private final AbstractValidator validator = new IdValidatorImpl();
    private static final String CORRECT_ID = "12";
    private static final String INCORRECT_ID = "-12";

    @Test
    public void testIdValidator_ShouldReturnTrue_WhenDataIsCorrect() {
        boolean actual = validator.isValid(CORRECT_ID);
        assertTrue(actual);
    }

    @Test
    public void testIdValidator_ShouldReturnFalse_WhenDataIsNotCorrect() {
        boolean actual = validator.isValid(INCORRECT_ID);
        assertFalse(actual);
    }
}