package com.company.ui.controllers;

import com.company.DB.UserJDBCDao;
import com.company.controller.UserController;
import com.company.dto.LoginDto;
import com.company.ui.views.CarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginController implements ActionListener {

    UserController userController;
    JTextField login;
    JPasswordField password;
    public LoginController(JTextField login, JPasswordField password) throws SQLException {
        super();

        this.login = login;
        this.password = password;

        userController = new UserController(new UserJDBCDao());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var result = userController.login(new LoginDto(login.getText(), password.getText()));
        if(result) {
            new CarView();
        }
    }
}