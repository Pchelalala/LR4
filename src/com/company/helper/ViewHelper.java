package com.company.helper;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.WindowEvent;

public class ViewHelper {

    public static JPanel getCtrlPane() {
        JPanel ctrlPane = new JPanel();
        return ctrlPane;
    }

    public static JScrollPane getJScrollPane() {
        JScrollPane tableScrollPane = new JScrollPane();
        tableScrollPane.setPreferredSize(new Dimension(1000, 300));
        tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Market Movers",
                TitledBorder.CENTER, TitledBorder.TOP));
        return tableScrollPane;
    }


    public static JSplitPane getSplitPane(JPanel ctrlPane, JScrollPane tableScrollPane) {
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, tableScrollPane);
        splitPane.setDividerLocation(35);
        splitPane.setEnabled(false);
        return splitPane;
    }

    public static JFrame getFrame(JSplitPane splitPane) {
        JFrame frame = new JFrame("Swing MVC Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(splitPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent winEvt) {
                JOptionPane.showMessageDialog(frame, "Goodbye.");
              //  System.exit(0);
            }
        });
        return frame;
    }

    public static void setComboBox(JFrame f, JPanel ctrlPane) {
        String s1[] = { "Jalpaiguri", "Mumbai", "Noida", "Kolkata", "New Delhi" };
        JComboBox comboBox = new JComboBox(s1);
        JLabel jLabel = new JLabel("select your city ");

        jLabel.setForeground(Color.red);

        ctrlPane.add(jLabel);

        ctrlPane.add(comboBox);

        f.setSize(400, 300);
    }
    public static void setRadioButton(JFrame f, JPanel ctrlPane) {
        JRadioButton jRadioButton = new JRadioButton();
        jRadioButton.setText("Select some info");
        ctrlPane.add(jRadioButton);

        f.setSize(400, 300);
    }
    public static void setMenu(JFrame f) {
        JMenu menu, submenu;
        JMenuItem i1, i2, i3, i4, i5;
        JMenuBar mb = new JMenuBar();
        menu = new JMenu("Menu");
        submenu = new JMenu("Sub Menu");
        i1 = new JMenuItem("Item 1");
        i2 = new JMenuItem("Item 2");
        i3 = new JMenuItem("Item 3");
        i4 = new JMenuItem("Item 4");
        i5 = new JMenuItem("Item 5");
        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        submenu.add(i4);
        submenu.add(i5);
        menu.add(submenu);
        mb.add(menu);

        f.setJMenuBar(mb);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void setJSpinner(JPanel ctrlPane) {
        JSpinner s = new JSpinner();

        // set Bounds for spinner
        s.setBounds(70, 70, 50, 40);


        ctrlPane.add( s);
    }
}
