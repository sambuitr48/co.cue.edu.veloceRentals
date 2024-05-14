package controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapping.dtos.VehicleDTO;
import model.Vehicle;
import model.VehicleCategory;
import service.VehicleService;

import java.io.IOException;
@WebServlet
public class RegisterVehicleServlet extends HttpServlet {
    @Inject
    private VehicleService vehicleService;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // Procesar el formulario de registro de vehículos
        VehicleCategory category = VehicleCategory.valueOf(request.getParameter("category"));
        String brand = request.getParameter("brand");
        String plate = request.getParameter("plate");
        Double price = Double.valueOf(request.getParameter("price"));
        String state = request.getParameter("state");

        VehicleDTO v = new VehicleDTO(1, category, brand, plate, price, state);
        // Guardar el vehículo en la base de datos
        vehicleService.save(v);

        // Redirigir a otra página después de guardar el vehículo
        resp.sendRedirect(request.getContextPath() + "/registrationSuccess.jsp");
    }

}
