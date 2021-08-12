package by.epam.onlineShop.service.validator.impl;

import by.epam.onlineShop.service.validator.AbstractValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NameValidatorTest {
    private final AbstractValidator validator = new NameValidatorImpl();
    private static final String CORRECT_NAME = "Test";
    private static final String INCORRECT_NAME = "test";

    @Test
    public void testNameValidator_ShouldReturnTrue_WhenDataIsCorrect() {
        boolean actual = validator.isValid(CORRECT_NAME);
        assertTrue(actual);
    }

    @Test
    public void testNameValidator_ShouldReturnFalse_WhenDataIsNotCorrect() {
        boolean actual = validator.isValid(INCORRECT_NAME);
        assertFalse(actual);
    }
}