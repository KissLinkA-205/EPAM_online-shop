package by.epam.onlineShop.logic.command.impl;

import by.epam.onlineShop.context.RequestContext;
import by.epam.onlineShop.context.RequestContextHelper;
import by.epam.onlineShop.entity.Category;
import by.epam.onlineShop.exeptions.ServiceException;
import by.epam.onlineShop.logic.command.Command;
import by.epam.onlineShop.logic.command.CommandResult;
import by.epam.onlineShop.logic.command.CommandResultType;
import by.epam.onlineShop.logic.service.ContactsService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GoToContactsCommand implements Command {
    private static final String PAGE = "WEB-INF/view/contacts.jsp";
    private static final String CATEGORIES = "categories";
    private final ContactsService contactsService;

    public GoToContactsCommand(ContactsService contactsService) {
        this.contactsService = contactsService;
    }
    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException {
        RequestContext context = helper.createContext();
        List<Category> categories = contactsService.getCategories();
        context.addRequestAttribute(CATEGORIES, categories);
        helper.updateRequest(context);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
