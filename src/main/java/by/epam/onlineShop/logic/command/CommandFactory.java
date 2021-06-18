package by.epam.onlineShop.logic.command;

public class CommandFactory {
    private static final String AUTHORIZATION = "authorization";
    private static final String ERROR = "Illegal Command";

    public static Command createCommand(String command) {
        switch (command) {
            case AUTHORIZATION:

            default:
                throw new IllegalArgumentException(ERROR);
        }
    }
}
