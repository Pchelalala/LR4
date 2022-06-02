package com.company.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    private static ConnectionFactory instance = new ConnectionFactory();
    private static Connection connectionInstance;
    public static String URL = "jdbc:sqlite:identifier.sqlite";
    public static String DRIVER_CLASS = "org.sqlite.JDBC";

    private ConnectionFactory(){

    }
    public Connection createConnection()
    {
        if(connectionInstance == null){
            try {
                connectionInstance = DriverManager.getConnection(URL);
            }
            catch (SQLException ex) {
                throw new RuntimeException("Error connecting to the database", ex);
            }
        }
        return connectionInstance;
    }
    public static Connection getConnection(){
        return instance.createConnection();
    }
}