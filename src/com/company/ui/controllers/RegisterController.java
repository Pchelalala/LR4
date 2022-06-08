package com.company.ui.controllers;

import com.company.DB.UserJDBCDao;
import com.company.controller.UserController;
import com.company.dto.RegisterDto;
import com.company.ui.views.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterController implements ActionListener {
    UserController userController;
    JTextField login;
    JPasswordField password;

    public RegisterController(JTextField login, JPasswordField password) throws SQLException {
        super();

        this.login = login;
        this.password = password;
        userController = new UserController(new UserJDBCDao());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var result = this.userController.registration(new RegisterDto(login.getText(), password.getText()));

        if (result) {
            try {
                new LoginView();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}