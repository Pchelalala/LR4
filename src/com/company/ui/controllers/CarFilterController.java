package com.company.ui.controllers;

import com.company.model.Car;
import com.company.ui.View;
import com.company.ui.tableModel.CarModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarFilterController implements ActionListener {
    private final JTextField searchTermTextField;
    private final DefaultTableModel model;

    public CarFilterController(JTextField searchTermTextField, DefaultTableModel model) {
        super();
        this.searchTermTextField = searchTermTextField;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String searchTerm = searchTermTextField.getText();
        if (searchTerm != null && !"".equals(searchTerm)) {
            Object[][] newData = new Object[CarModel.data.length][];
            int idx = 0;
            for (Object[] o: CarModel.data) {
                if ("*".equals(searchTerm.trim())) {
                    newData[idx++] = o;
                    continue;
                }
                if(String.valueOf(o[0]).startsWith(searchTerm.toUpperCase().trim())){
                    newData[idx++] = o;
                }
            }
            model.setDataVector(newData, CarModel.headers);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Search term is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        new View();
    }

}
