package controllers;

import config.DataBaseConnection;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.User;
import service.UserService;

import java.io.IOException;

@WebServlet(value="/Login")
public class LoginServlet extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        try {
            if (accion != null) {
                switch (accion) {
                    case "verificar":
                        verificar(req, resp);
                        break;
                    case "cerrar":
                        cerrar(req, resp);
                    default:
                        resp.sendRedirect("login.jsp");
                }

            } else {
                resp.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }
    }

    private void cerrar(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void verificar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session;
        DataBaseConnection dbs;
        User us;
        us = this.getUser(req);
        us = userService.verifyExist(us.getMail(),us.getPassword());
        if (us != null){
            session = req.getSession();
            session.setAttribute("usuario", us);
            req.setAttribute("msje","benvenute");
            this.getServletConfig().getServletContext().getRequestDispatcher("index.jsp").forward(req, resp);
        }else{
            req.setAttribute("msje", "esta malo");
            req.getRequestDispatcher("registration.jsp").forward(req,resp);
        }
        Cookie cookie = new Cookie("username", req.getParameter("username"));
        cookie.setMaxAge(24 * 60 * 60); // La cookie expirará en 24 horas
        resp.addCookie(cookie);
    }

    private User getUser(HttpServletRequest req) {
        User u = new User();
        u.setName(req.getParameter("username"));
        u.setPassword(req.getParameter("password"));
        return u;
    }
}
