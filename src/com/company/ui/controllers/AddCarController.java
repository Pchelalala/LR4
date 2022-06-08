package com.company.ui.controllers;

import com.company.DB.CarJDBCDao;
import com.company.controller.CarController;
import com.company.dto.CarInsertDto;
import com.company.ui.View;
import com.company.ui.tableModel.CarModel;
import com.company.ui.views.CarView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddCarController implements ActionListener {
    CarController carController;

    private final JTextField name;
    private final JTextField power;
    private final JTextField cost;

    public AddCarController(JTextField name, JTextField power, JTextField cost) {
        super();

        this.name = name;
        this.power = power;
        this.cost = cost;
        try {
            carController = new CarController(new CarJDBCDao());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        carController.insert(new CarInsertDto(name.getText(), Integer.parseInt(power.getText()), Integer.parseInt(cost.getText())));
        new CarView();
    }

}
