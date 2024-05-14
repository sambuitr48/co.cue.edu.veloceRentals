package service;

import mapping.dtos.UserDTO;
import model.User;

import java.util.List;

public interface UserService {
    List<User> list();
    User verifyExist(String mail, String password);
    int save (UserDTO user);
    void delete(int id);
}
