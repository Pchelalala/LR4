package com.company.ui.tableModel;

import com.company.DB.CarJDBCDao;
import com.company.DB.UserJDBCDao;
import com.company.helper.TableModelHelper;
import com.company.model.Car;
import com.company.model.User;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

public class UserModel extends DefaultTableModel {
    static UserJDBCDao userJDBCDao;
    static Object[][] data;
    static Object[] headers;
    static {
        try {
            userJDBCDao = new UserJDBCDao();
            data = TableModelHelper.makeData(User.class.getFields(), userJDBCDao.getAll());
            headers = TableModelHelper.makeHeaders(User.class.getFields());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UserModel() {
        super(data, headers);
    }
}
