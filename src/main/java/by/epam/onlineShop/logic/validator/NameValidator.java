package by.epam.onlineShop.logic.validator;

public class NameValidator extends AbstractValidator {
    private static final String NAME_REGEX = "^[A-Z]{1}[A-z]{2,29}$";

    @Override
    protected String getRegex() {
        return NAME_REGEX;
    }
}
