package service;

import mapping.dtos.VehicleDTO;
import model.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> list();
    Vehicle verifyExist(int id);
    int save(VehicleDTO vehicleDTO);
    void delete(int id);
}
