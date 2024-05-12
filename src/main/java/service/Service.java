package service;

import mapping.dtos.UserDTO;
import model.User;

import java.util.List;

public interface Service {
    List<User> list();
    User byId(Integer id);
    int save (UserDTO user);
    void delete(int id);
}
