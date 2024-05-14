package filter;

import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebFilter;
import repository.impl.user.UserUserRepositoryJdbcImpl;
import service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.impl.user.UserUserServiceImpl;

import java.io.IOException;
@WebFilter("/Login")
public class LoginFilter implements Filter {
    @Inject
    private UserService userService;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

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
                    "Lo sentimos, no estás autorizado para ingresar a esta página");
        }
    }
}
