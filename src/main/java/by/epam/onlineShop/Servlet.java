package by.epam.onlineShop;

import by.epam.onlineShop.connection.ConnectionPool;
import by.epam.onlineShop.context.RequestContextHelper;
import by.epam.onlineShop.exeptions.ConnectionException;
import by.epam.onlineShop.logic.command.Command;
import by.epam.onlineShop.logic.command.CommandFactory;
import by.epam.onlineShop.logic.command.CommandResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Servlet extends HttpServlet {
    private static final String COMMAND = "command";
    private static final String PATH = "/online-shop?";

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            ConnectionPool.getInstance();
        } catch (ConnectionException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {
        try {
            ConnectionPool.getInstance().destroy();
            super.destroy();
        } catch (ConnectionException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String commandName = request.getParameter(COMMAND);
        if (commandName == null || "".equals(commandName)) {
            request.getRequestDispatcher("WEB-INF/view/main.jsp").forward(request, response);
        } else {
            Command command = CommandFactory.createCommand(commandName);
            RequestContextHelper contextHelper = new RequestContextHelper(request);

            CommandResult result = command.execute(contextHelper, response);
            dispatch(result, request, response);
        }
    }

    private void dispatch(CommandResult result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (result.isRedirect()) {
            response.sendRedirect(PATH + result.getPage());
        } else {
            request.getRequestDispatcher(result.getPage()).forward(request, response);
        }
    }
}