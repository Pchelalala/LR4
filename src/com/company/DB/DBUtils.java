package com.company.DB;

import com.company.Car;
import com.company.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class DBUtils {
    public static void close(Connection connection){
        if(connection == null) return;
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void close(ResultSet resultSet){
        if(resultSet == null) return;
        try {
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void initBD() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        dropDBTable(connection);

        Statement stmt = connection.createStatement();

        executeQuery(stmt,
                "CREATE TABLE IF NOT EXISTS User (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "name TEXT NOT NULL," +
                            "password TEXT NOT NULL" +
                        ")");
        executeQuery(stmt,
                "CREATE TABLE IF NOT EXISTS Car (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "name TEXT NOT NULL," +
                            "cost INTEGER NOT NULL," +
                            "power INTEGER NOT NULL," +
                            "isServiceable BOOLEAN NOT NULL" +
                        ")");
        stmt.close();
    }
    public static void dropDBTable(Connection connection) throws SQLException {
        Statement  stmt = connection.createStatement();
        executeQuery(stmt,
                "drop table if exists User;drop table if exists Car;");
    }
    public static void executeQuery(Statement stmt, String query) throws SQLException {
        stmt.executeUpdate(query);
    }

    public static Optional<Car> getCar(ResultSet rs) throws SQLException {

        var car = new Car();

        car.setId(rs.getInt("id"));
        car.setCost(rs.getInt("cost"));
        car.setPower(rs.getInt("power"));
        car.setName(rs.getString("name"));
        car.setServiceable(rs.getBoolean("isServiceable"));

        return Optional.of(car);
    }

    public static Optional<User> getUser(ResultSet rs) throws SQLException {

        var user = new User();

        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        return Optional.of(user);
    }
}
