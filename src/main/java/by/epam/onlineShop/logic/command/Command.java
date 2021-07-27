package by.epam.onlineShop.logic.command;

import by.epam.onlineShop.context.RequestContextHelper;
import by.epam.onlineShop.exeptions.ServiceException;

import javax.servlet.http.HttpServletResponse;

public interface Command {
    CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException;
}
