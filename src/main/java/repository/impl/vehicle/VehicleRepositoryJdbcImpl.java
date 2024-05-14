package repository.impl.vehicle;

import annotations.Mysqlconn;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import model.Vehicle;
import model.VehicleCategory;
import repository.VehicleRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class VehicleRepositoryJdbcImpl implements VehicleRepository<Vehicle> {
    @Inject
    @Mysqlconn
    private Connection conn;
    private Vehicle createVehicle(ResultSet resultSet) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_id(resultSet.getInt("vehicle_id"));
        vehicle.setVehicleCategory(VehicleCategory.valueOf(resultSet.getString("vehicle_category")));
        vehicle.setBrand(resultSet.getString("brand"));
        vehicle.setPlate(resultSet.getString("plate"));
        vehicle.setPrice(resultSet.getDouble("price"));
        vehicle.setState(resultSet.getString("state"));
        return vehicle;
    }

    @Override
    public List<Vehicle> list() {
        List<Vehicle> vehicleList = new ArrayList<>();
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM vehicles")
        ) {
            while (resultSet.next()) {
                Vehicle vehicle = createVehicle(resultSet);
                vehicleList.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicleList;
    }

    @Override
    public Vehicle verifyExist(int id) {
        Vehicle vehicle = null;
        try (PreparedStatement preparedStatement = conn.prepareStatement(
                "SELECT * FROM vehicles WHERE vehicle_id = ?")
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                vehicle = createVehicle(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    @Override
    public void save(Vehicle vehicle) {
        int idGenerator = 0;
        try (PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO vehicles (vehicle_category, brand, plate, price, state) VALUES (?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, vehicle.getVehicleCategory().toString());
            preparedStatement.setString(2, vehicle.getBrand());
            preparedStatement.setString(3, vehicle.getPlate());
            preparedStatement.setDouble(4, vehicle.getPrice());
            preparedStatement.setString(5, vehicle.getState());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                idGenerator = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = conn.prepareStatement(
                "DELETE FROM vehicles WHERE vehicle_id = ?")
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
