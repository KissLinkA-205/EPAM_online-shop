package by.epam.onlineShop.logic.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractValidator {
    protected abstract String getRegex();

    public boolean isValid(String expression){
        Pattern pattern = Pattern.compile(getRegex());
        Matcher matcher = pattern.matcher(expression);
        return matcher.find();
    }
}
