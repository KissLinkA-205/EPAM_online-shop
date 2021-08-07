package by.epam.onlineShop.controller.command;

import by.epam.onlineShop.controller.context.RequestContextHelper;

import javax.servlet.http.HttpServletResponse;

public interface Command {

    /**
     * Method that is executed by controller when certain command is called
     *
     * @param helper   RequestContextHelper from incoming request
     * @param response HttpServletResponse for incoming request
     * @return CommandResult of page with routing type
     */
    CommandResult execute(RequestContextHelper helper, HttpServletResponse response);
}
