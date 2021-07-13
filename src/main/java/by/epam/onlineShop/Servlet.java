package by.epam.onlineShop;

import by.epam.onlineShop.connection.ConnectionPool;
import by.epam.onlineShop.exeptions.ConnectionException;
import by.epam.onlineShop.logic.command.Command;
import by.epam.onlineShop.logic.command.CommandFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {
    private static final String COMMAND = "command";
    private static final Logger LOGGER = Logger.getLogger(Servlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            ConnectionPool.getInstance();
        } catch (ConnectionException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {
        try {
            ConnectionPool.getInstance().destroy();
            super.destroy();
        } catch (ConnectionException e) {
            LOGGER.error(e.getMessage(), e);
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
        Command command = CommandFactory.createCommand(commandName);
    }
}