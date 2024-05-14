package repository;

import java.util.List;

public interface UserRepository<T>{
    List<T> list();
    T verifyExist(String mail, String password);
    void save (T t);
    void delete(int id);
}
