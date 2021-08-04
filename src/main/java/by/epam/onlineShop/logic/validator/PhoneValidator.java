package by.epam.onlineShop.logic.validator;

public class PhoneValidator extends AbstractValidator {
    private static final String PHONE_REGEX = "^[0-9]{10,15}$";


    @Override
    protected String getRegex() {
        return PHONE_REGEX;
    }
}
