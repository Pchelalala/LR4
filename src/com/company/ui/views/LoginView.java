package com.company.ui.views;

import com.company.ui.controllers.LoginController;
import com.company.ui.controllers.RegisterController;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

import static com.company.helper.ViewHelper.*;

public class LoginView {
    public LoginView() throws SQLException {
        JTextField login = new JTextField(26);
        JPasswordField password = new JPasswordField(26);

        JLabel loginLabel = new JLabel("Login");
        JLabel passwordLabel = new JLabel("Password");

        JButton logInButton = new JButton("Log in");
        JButton registerButton = new JButton("Register");

        logInButton.addActionListener(new LoginController(login, password));
        registerButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterView();
            }
        });
        JPanel ctrlPane = getCtrlPane();
        ctrlPane.add(login);
        ctrlPane.add(password);
        ctrlPane.add(loginLabel);
        ctrlPane.add(passwordLabel);
        ctrlPane.add(logInButton);
        ctrlPane.add(registerButton);

        JScrollPane tableScrollPane = getJScrollPane();

        JSplitPane splitPane = getSplitPane(ctrlPane, tableScrollPane);

        JFrame frame = getFrame(splitPane);

    }
}
