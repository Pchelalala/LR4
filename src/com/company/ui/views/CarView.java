package com.company.ui.views;

import com.company.ui.controllers.CarFilterController;
import com.company.ui.tableModel.CarModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.company.helper.ViewHelper.*;
import static com.company.helper.ViewHelper.getFrame;

public class CarView {
    public CarView() {
        JTextField searchTermTextField = new JTextField(26);
        JLabel label = new JLabel();
        label.setFont(new Font("Calibri", Font.PLAIN, 20));
        label.setHorizontalAlignment(JLabel.CENTER);

        searchTermTextField.addKeyListener(new KeyListener() {

            public void keyPressed(KeyEvent e) {
                label.setText(KeyEvent.getKeyText(e.getKeyCode()));

            }

            public void keyReleased(KeyEvent e) {

            }

            public void keyTyped(KeyEvent e) {

            }

        });
        JButton filterButton = new JButton("Filter");
        JButton addNewCar = new JButton("Add new car");
        JTable table = new JTable();

        CarModel model = new CarModel();
        table.setModel(model);

        CarFilterController controller = new CarFilterController(searchTermTextField, model);
        filterButton.addActionListener(controller);
        addNewCar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCarView();
            }
        });

        JPanel ctrlPane = getCtrlPane();
        ctrlPane.add(searchTermTextField);
        ctrlPane.add(filterButton);
        ctrlPane.add(addNewCar);

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setPreferredSize(new Dimension(1000, 300));
        tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Market Movers",
                TitledBorder.CENTER, TitledBorder.TOP));

        JSplitPane splitPane = getSplitPane(ctrlPane, tableScrollPane);

        JFrame frame = getFrame(splitPane);
        setMenu(frame);
        setComboBox(frame, ctrlPane);
        setRadioButton(frame, ctrlPane);
        ctrlPane.add(label);
        setJSpinner(ctrlPane);
    }
}
