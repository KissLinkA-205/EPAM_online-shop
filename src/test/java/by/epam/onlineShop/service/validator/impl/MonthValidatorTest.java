package by.epam.onlineShop.service.validator.impl;

import by.epam.onlineShop.service.validator.AbstractValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MonthValidatorTest {
    private final AbstractValidator validator = new MonthValidatorImpl();
    private static final String CORRECT_MONTH = "12";
    private static final String INCORRECT_MONTH = "13";

    @Test
    public void testMonthValidator_ShouldReturnTrue_WhenDataIsCorrect() {
        boolean actual = validator.isValid(CORRECT_MONTH);
        assertTrue(actual);
    }

    @Test
    public void testMonthValidator_ShouldReturnFalse_WhenDataIsNotCorrect() {
        boolean actual = validator.isValid(INCORRECT_MONTH);
        assertFalse(actual);
    }
}