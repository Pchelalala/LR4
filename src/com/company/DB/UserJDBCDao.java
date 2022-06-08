package com.company.DB;


import com.company.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserJDBCDao implements IDao<User> {
    Connection connection;
    Statement statement;

    public UserJDBCDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
        statement = connection.createStatement();
    }

    @Override
    public Optional<User> get(int id) {
        Optional<User> result = Optional.empty();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM [User] WHERE id=" + id);

            if (rs.next()) {
                result = DBUtils.getUser(rs);
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
    public List<User> getAll() {
        List<User> cars = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM [User]");

            while (rs.next()) {
                cars.add(DBUtils.getUser(rs).get());
            }

            DBUtils.close(rs);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cars;
    }

    @Override
    public boolean insert(User user) {
        boolean result = false;
        try {
            Statement statement = connection.createStatement();
            result = statement.execute(
                    "INSERT INTO User(name, password) " +
                            "VALUES('"  + user.getName() + "'," +
                                          user.getPassword() +

                            ");");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("User inserted");
        return result;
    }

    @Override
    public boolean update(User user) {
        boolean result = false;
        try {
            Statement statement = connection.createStatement();
            result = statement.execute(
                    "UPDATE User" +
                            "SET " +
                                "name = '" + user.getName() + "'," +
                                "password = " + user.getPassword() +

                            "WHERE id = " + user.getId() + ";");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(User user) {
        boolean result = false;
        try {
            result = statement.execute(
                    "DELETE FROM User WHERE id=" + user.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("User deleted");
        return result;
    }

    @Override
    public boolean clearData() {
        boolean result = false;
        try {
            result = statement.execute(
                    "DELETE FROM User");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
