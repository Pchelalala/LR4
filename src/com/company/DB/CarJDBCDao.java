package com.company.DB;


import com.company.model.Car;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarJDBCDao implements IDao<Car> {
    Connection connection;
    Statement statement;

    public CarJDBCDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
        statement = connection.createStatement();
    }

    @Override
    public Optional<Car> get(int id) {
        Optional<Car> result = Optional.empty();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM [Car] WHERE id=" + id);

            if (rs.next()) {
                result = DBUtils.getCar(rs);
                if(result.isEmpty()){
                    return Optional.empty();
                }
            }
            DBUtils.close(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Car> getAll() {
        List<Car> cars = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM [Car]");

            while (rs.next()) {
                cars.add(DBUtils.getCar(rs).get());
            }

            DBUtils.close(rs);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cars;
    }

    @Override
    public boolean insert(Car car) {
        boolean result = false;
        try {
            Statement statement = connection.createStatement();
            result = statement.execute(
                    "INSERT INTO Car(name, cost, power, isServiceable) " +
                            "VALUES('"  + car.getName() + "'," +
                                          car.getCost() +"," +
                                          car.getPower() +"," +
                                          car.isServiceable()     +
                            ");");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Car inserted");
        return result;
    }

    @Override
    public boolean update(Car car) {
        boolean result = false;
        try {
            Statement statement = connection.createStatement();
            result = statement.execute(
                    "UPDATE Car" +
                            "SET " +
                                "name = '" + car.getName() + "'," +
                                "cost = " + car.getCost() + "," +
                                "power = " + car.getPower() + "," +
                                "isServiceable = " + car.isServiceable() +
                            "WHERE id = " + car.getId() + ";");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(Car car) {
        boolean result = false;
        try {
            result = statement.execute(
                    "DELETE FROM Car WHERE id=" + car.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Car deleted");
        return result;
    }

    @Override
    public boolean clearData() {
        boolean result = false;
        try {
            result = statement.execute(
                    "DELETE FROM Car");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
