package by.epam.onlineShop;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.io.PrintWriter;

import by.epam.onlineShop.logic.command.Command;
import by.epam.onlineShop.logic.command.CommandFactory;
import org.apache.log4j.Logger;

public class Servlet extends HttpServlet {
    private static final String COMMAND = "command";
    private static final Logger LOGGER = Logger.getLogger(Servlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter pw = response.getWriter();

            pw.println("<html>");
            pw.println("<h1> Hello world! </h1>");
            pw.println("</html>");
    }
}
