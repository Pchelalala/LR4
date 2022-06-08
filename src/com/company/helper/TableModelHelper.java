package com.company.helper;

import com.company.model.Car;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableModelHelper {

    public static Object[] makeHeaders(Field[] fields){
        Object[] tableHeader = Arrays.stream(fields).map(Field::getName).toArray();

       return tableHeader;
    }
    public static<T> Object[][] makeData(Field[] fields, List<T> entities){
        List<Object[]> objects = new ArrayList<>();

        for (var item : entities) {
            List<Object> itemFieldValues = new ArrayList<>();
            for (var field : fields) {
                try {
                    itemFieldValues.add(field.get(item));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            objects.add(itemFieldValues.toArray(new Object[0]));
        }

        return objects.toArray(new Object[0][]);
    }
}
