package com.company.ui.views;

import com.company.ui.controllers.AddCarController;
import com.company.ui.controllers.RegisterController;

import javax.swing.*;
import java.sql.SQLException;

import static com.company.helper.ViewHelper.*;
import static com.company.helper.ViewHelper.getFrame;

public class AddCarView {
    public AddCarView(){

        JTextField name = new JTextField(26);
        JTextField power = new JTextField(26);
        JTextField cost = new JTextField(26);

        JLabel nameLabel = new JLabel("Login Power Cost");

        JButton registerButton = new JButton("Register");

        registerButton.addActionListener(new AddCarController(name, power, cost));

        JPanel ctrlPane = getCtrlPane();
        ctrlPane.add(name);
        ctrlPane.add(power);
        ctrlPane.add(cost);
        ctrlPane.add(nameLabel);
        ctrlPane.add(registerButton);

        JScrollPane tableScrollPane = getJScrollPane();

        JSplitPane splitPane = getSplitPane(ctrlPane, tableScrollPane);

        JFrame frame = getFrame(splitPane);
    }
}
