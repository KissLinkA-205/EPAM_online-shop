package by.epam.onlineShop.filter;

import by.epam.onlineShop.context.RequestContext;
import by.epam.onlineShop.context.RequestContextHelper;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LanguageFilter implements Filter {
    private static final String ATTRIBUTE = "language";
    private static final String EN = "en";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        RequestContextHelper requestHelper = new RequestContextHelper(request);
        RequestContext requestContext = requestHelper.createContext();
        String language = (String) requestContext.getSessionAttribute(ATTRIBUTE);
        if (language == null) {
            requestContext.addSessionAttribute(ATTRIBUTE, EN);
            requestHelper.updateRequest(requestContext);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
