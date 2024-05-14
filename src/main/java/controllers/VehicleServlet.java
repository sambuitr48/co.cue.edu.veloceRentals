package controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Vehicle;
import service.VehicleService;

import java.io.IOException;
import java.util.List;
@WebServlet
public class VehicleServlet extends HttpServlet {
    @Inject
    private VehicleService vehicleService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener la lista de vehículos desde el servicio
        List<Vehicle> vehicles = vehicleService.list();

        // Establecer la lista de vehículos como atributo de la solicitud
        req.setAttribute("vehicles", vehicles);

        // Reenviar la solicitud al archivo JSP para mostrar la lista de vehículos
        req.getRequestDispatcher("/WEB-INF/vehicle.jsp").forward(req, resp);
    }
}
