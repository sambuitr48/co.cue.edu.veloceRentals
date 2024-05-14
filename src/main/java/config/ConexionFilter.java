package config;

import config.DataBaseConnection;
import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexionFilter implements Filter {
    private Connection conn;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            this.conn = DataBaseConnection.getInstance();
        } catch (SQLException e) {
            throw new ServletException("Error al obtener la conexión a la base de datos", e);
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
        boolean userAuthenticated = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    userAuthenticated = true;
                    break;
                }
            }
        }
        try {
            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }
            try {
                filterChain.doFilter(servletRequest, servletResponse);
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                ((HttpServletResponse) servletRequest).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                        e.getMessage());
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new ServletException("Error al configurar la conexión a la base de datos", e);
        }
    }

    @Override
    public void destroy() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
