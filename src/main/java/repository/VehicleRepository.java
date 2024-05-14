package repository;

import mapping.dtos.VehicleDTO;

import java.util.List;

public interface VehicleRepository <T>{
    List<T> list();
    T verifyExist(int id);
    void save(T t);

    void delete(int id);
}
