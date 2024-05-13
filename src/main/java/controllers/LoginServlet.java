package controllers;

import config.DataBaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import repository.impl.user.UserRepositoryJdbcImpl;
import service.Service;
import service.impl.UserServiceImpl;

import java.io.IOException;

@WebServlet(value="/Login")
public class LoginServlet extends HttpServlet {

    private UserRepositoryJdbcImpl repos;
    private Service service;

    public LoginServlet() {
        this.repos = new UserRepositoryJdbcImpl();
        this.service = new UserServiceImpl(repos);
    }

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
        HttpSession sesion;
        DataBaseConnection dbs;
        User us;
        us = this.getUser(req);
        us = service.verifyExist(us.getMail(),us.getPassword());
        if (us != null){
            sesion = req.getSession();
            sesion.setAttribute("usuario", us);
            req.setAttribute("msje","benvenute");
            this.getServletConfig().getServletContext().getRequestDispatcher("index.jsp").forward(req, resp);
        }else{
            req.setAttribute("msje", "esta malo");
            req.getRequestDispatcher("registration.jsp").forward(req,resp);
        }
    }

    private User getUser(HttpServletRequest req) {
        User u = new User();
        u.setName(req.getParameter("username"));
        u.setPassword(req.getParameter("password"));
        return u;
    }
}
