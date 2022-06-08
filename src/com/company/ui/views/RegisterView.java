package com.company.ui.views;

import com.company.ui.controllers.RegisterController;

import javax.swing.*;

import java.sql.SQLException;

import static com.company.helper.ViewHelper.*;
import static com.company.helper.ViewHelper.getFrame;

public class RegisterView {
    public RegisterView(){
        JTextField login = new JTextField(26);
        JPasswordField password = new JPasswordField(26);

        JLabel loginLabel = new JLabel("Login");
        JLabel passwordLabel = new JLabel("Password");

        JButton registerButton = new JButton("Register");

        try {
            registerButton.addActionListener(new RegisterController(login, password));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        JPanel ctrlPane = getCtrlPane();
        ctrlPane.add(login);
        ctrlPane.add(password);
        ctrlPane.add(loginLabel);
        ctrlPane.add(passwordLabel);
        ctrlPane.add(registerButton);

        JScrollPane tableScrollPane = getJScrollPane();

        JSplitPane splitPane = getSplitPane(ctrlPane, tableScrollPane);

        JFrame frame = getFrame(splitPane);
    }
}
