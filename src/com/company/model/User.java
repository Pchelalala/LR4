package com.company.model;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class User {
    public Integer id;
    public String name;
    public String password;
    public String statement;
    public Map<LocalDate,String> userHistory = new HashMap<>();
    public User() {
    }
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public Map<LocalDate, String> getUserHistory() {
        return userHistory;
    }

    public void setUserHistory(Map<LocalDate, String> userHistory) {
        this.userHistory = userHistory;
    }
}
