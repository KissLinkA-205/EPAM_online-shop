package by.epam.onlineShop.controller.filter;

import by.epam.onlineShop.controller.context.RequestContext;
import by.epam.onlineShop.controller.context.RequestContextHelper;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class LanguageFilter implements Filter {
    private static final String ATTRIBUTE = "language";
    private static final String RU = "ru";

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        RequestContextHelper requestHelper = new RequestContextHelper(request);
        RequestContext requestContext = requestHelper.createContext();
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String sessionLanguage = (String) requestContext.getSessionAttribute(ATTRIBUTE);
        if (sessionLanguage == null) {
            requestContext.addSessionAttribute(ATTRIBUTE, RU);
            requestHelper.updateRequest(requestContext);
        }

        String requestLanguage = request.getParameter(ATTRIBUTE);
        if (requestLanguage != null) {
            requestContext.addSessionAttribute(ATTRIBUTE, requestLanguage);
            String requestString = removeLanguageParameter(request);
            requestHelper.updateRequest(requestContext);
            response.sendRedirect(requestString);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String removeLanguageParameter(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        StringBuilder requestString = new StringBuilder(request.getContextPath() + "/online-shop?");
        parameterMap.entrySet().stream()
                .filter(e -> !ATTRIBUTE.equals(e.getKey()))
                .forEach(e -> requestString.append(e.getKey()).append("=").append(e.getValue()[0]).append("&"));
        requestString.deleteCharAt(requestString.length() - 1);
        return requestString.toString();
    }

    @Override
    public void destroy() {

    }
}
