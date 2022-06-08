package com.company.controller;

import com.company.DB.UserJDBCDao;
import com.company.dto.LoginDto;
import com.company.dto.RegisterDto;
import com.company.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private UserJDBCDao userJDBCDao;

    public UserController(UserJDBCDao userJDBCDao){
        this.userJDBCDao = userJDBCDao;
    }

    public List<User> getAllUsers(){
        return userJDBCDao.getAll();
    }

    public boolean login(LoginDto loginDto){
        var users = getAllUsers();

        var result = users.stream()
                .filter(user ->
                        user.getName().equals(loginDto.getName())
                                &&
                        user.getPassword().equals(loginDto.getPassword())).findFirst();

        return result.isPresent();
    }
    public boolean registration(RegisterDto registerDto){
        var users = getAllUsers();


        var result = users.stream()
                .filter(user ->
                        user.getName().equals(registerDto.getName())
                                &&
                        user.getPassword().equals(registerDto.getPassword())).findFirst();

        if(result.isPresent()){
            return false;
        }

        User user = new User(registerDto.getName(), registerDto.getPassword());
        userJDBCDao.insert(user);

        return true;
    }
}
