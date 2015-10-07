package db.DAO;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Dmytry on 10/1/2015.
 */
public interface GenericDAO<T> {
    void insert(T t);
    T findById(T t);
    void update(T t);
    void deleteById(Object id);
    T map(ResultSet resultSet);
    List<T> mapAll(ResultSet resultSet);
}
