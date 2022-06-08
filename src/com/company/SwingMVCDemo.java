package com.company;


import com.company.ui.View;
import com.company.ui.tableModel.CarModel;
import com.company.ui.views.CarView;
import com.company.ui.views.LoginView;

import javax.swing.*;
import java.sql.SQLException;

public class SwingMVCDemo {

	public static void main(String[] args) throws SQLException {
		CarModel  model = new CarModel();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void createAndShowGUI() throws Exception {
		new LoginView();
	}
}
