package repository;

import java.util.List;

public interface Repository <T>{
    List<T> list();
    T byId(Integer id);
    void save (T t);
    void delete(int id);
}
