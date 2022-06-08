package com.company.ui.tableModel;

import com.company.DB.CarJDBCDao;
import com.company.DB.UserJDBCDao;
import com.company.helper.TableModelHelper;
import com.company.model.Car;
import com.company.model.User;

import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarModel extends DefaultTableModel {
    static CarJDBCDao carJDBCDao;
    public static Object[][] data;
    public static Object[] headers;

    {
        data = TableModelHelper.makeData(Car.class.getFields(), carJDBCDao.getAll());
        headers = TableModelHelper.makeHeaders(Car.class.getFields());
    }
    static {
        try {
            carJDBCDao = new CarJDBCDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public CarModel() {

        super(data, headers);
    }
}
