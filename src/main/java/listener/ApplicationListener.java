package listener;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class ApplicationListener implements ServletContextListener,
        ServletRequestListener, HttpSessionListener {
    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        servletContext = sce.getServletContext();
        servletContext.log("Inicializando la aplicación!");
        servletContext.setAttribute("mensaje", "algún valor global de la app");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        servletContext.log("Destruyendo la aplicación!");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletRequest request = sre.getServletRequest();
        servletContext.log("Inicializando request");
        request.setAttribute("mensaje", "guardando algún valor para el request");
        request.setAttribute("title", "Catalogo Servlet");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        servletContext.log("Destruyendo request");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        servletContext.log("Inicializando sesión http");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        servletContext.log("Destruyendo sesión http");
    }
}
