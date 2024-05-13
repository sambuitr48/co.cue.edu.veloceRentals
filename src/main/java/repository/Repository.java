package repository;

import java.util.List;

public interface Repository <T>{
    List<T> list();
    T verifyExist(String mail, String password);
    void save (T t);
    void delete(int id);
}
