package db.DAO;

import java.sql.ResultSet;

/**
 * Created by Dmytry on 10/1/2015.
 */
public interface GenericDAO<T> {
   // T create(T t);
    T findById(Object id);
    //T update(T t);
    void deleteById(Object id);
    T map(ResultSet resultSet);
}
