package db.DAO;

/**
 * Created by Dmytry on 10/1/2015.
 */
public interface GenericDAO<T> {
    T create(T t);
    T findById(Object id);
    T update(T t);
    void deleteById(Object id);
}
