package db.DAO;

import db.ConnectionHandler;
import utils.DatabaseProperties;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmytry on 10/1/2015.
 */
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {
    protected Connection connection = ConnectionHandler.getConnectionToDb(DatabaseProperties.DB_HOST, DatabaseProperties.DB_PORT, DatabaseProperties.DB_NAME);
    protected String tableName;

    public T findById(Object id) {
        ResultSet resultSet = null;
        try {
            System.out.println(String.format("SELECT * FROM %s WHERE id=%s", tableName, id));
            String query = String.format("SELECT * FROM %s WHERE id=?", tableName);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, (int)id);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map(resultSet);
    }

    public void deleteById(Object id) {
        try {
            System.out.println(String.format("DELETE FROM %s WHERE id=%s", tableName, id));
            String query = String.format("DELETE FROM %s WHERE id=?", tableName);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, (int)id);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error while trying to delete data!");
            e.printStackTrace();
        }
    }

    public List<T> getAll() {
        ResultSet resultSet = null;
        try {
            System.out.println(String.format("SELECT * FROM %s", tableName));
            String query = String.format("SELECT * FROM %s", tableName);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapAll(resultSet);
    }
}
