package filter;

import repository.impl.user.UserRepositoryJdbcImpl;
import service.Service;
import config.DataBaseConnection;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import service.Service;
import service.impl.UserServiceImpl;

import java.io.IOException;

public class LoginFilter implements Filter {
    private Service service;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.service = new UserServiceImpl(new UserRepositoryJdbcImpl());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpRequest.getSession(false);
        if (session != null && session.getAttribute("usuario") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "Lo sentimos, no estás autorizado para ingresar a esta página!");
        }
    }
}
