package controllers;

import config.DataBaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapping.dtos.UserDTO;
import model.User;
import repository.Repository;
import repository.impl.user.UserRepositoryJdbcImpl;
import service.Service;
import service.impl.UserServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private Connection getConnection() throws SQLException {
        return DataBaseConnection.getInstance();
    }
    private UserRepositoryJdbcImpl repos;
    private Service service;

    public RegistrationServlet() {
        this.repos = new UserRepositoryJdbcImpl();
        this.service = new UserServiceImpl(repos);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String name = req.getParameter("name");
            String mail = req.getParameter("email");
            String password = req.getParameter("pass");
            String mobile = req.getParameter("contact");
            UserDTO userDTO = UserDTO.builder()
                    .name(name)
                    .mail(mail)
                    .password(password)
                    .mobile(mobile)
                    .build();
            service.save(userDTO);
            //int id = service.save(userDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <title>Registration Successful</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <h1>Registration Successful!</h1>");
        out.println("    <p>Your account has been successfully registered.</p>");
        out.println("    <form action=\"/login.jsp\" method=\"get\">");
        out.println("        <button type=\"submit\">Login</button>");
        out.println("    </form>");
        out.println("</body>");
        out.println("</html>");
    }
}
