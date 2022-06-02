package com.company;

import com.company.DB.ConnectionFactory;
import com.company.DB.DBUtils;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static DataBase dataBase;

    static {
        try {
            DBUtils.initBD();
            dataBase = new DataBase();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        while (true) {
            Authorization();
        }
    }

    static void Authorization(){
        System.out.print("Choose role(admin/user):");
        Scanner in = new Scanner(System.in);
        String role = in.next();
        if(role.compareToIgnoreCase("admin") == 0){
            Admin admin = new Admin(dataBase);
            admin.Menu();
        }
        else if(role.compareToIgnoreCase("user") == 0){
            User user = new User(dataBase);
            user.UserMenu();
        }
        else{
            Authorization();
        }
    }
}
