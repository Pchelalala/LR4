package com.company;

import com.company.old.Car;
import com.company.old.DataBase;
import com.company.old.User;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataBaseTest {
    private DataBase dataBase;
    @Before
    public void initialize(){
        dataBase = new DataBase();
        dataBase.getBaseOfCars().clear();
    }

    @BeforeEach
    public void setDataBase(){
        dataBase = new DataBase();
    }

    @ParameterizedTest
    @MethodSource("testCarProvider")
    public void addNewCars(Car car){
        dataBase.getBaseOfCars().add(car);

        assertTrue(dataBase.getBaseOfCars().contains(car));
    }

    public static Stream<Car> testCarProvider(){
        return Stream.of(
                new Car("Car",100,22111,true),
                new Car("Mustang",180,1000000,false),
                new Car("Car1",100,22111,true)
        );
    }

    public static  Map<LocalDate,String> testUserHistoryProvider (){
        return new HashMap<>(){{
            put(LocalDate.now(), "Car");
            put(LocalDate.now(), "Car1");
            put(LocalDate.now(), "Mustang");
        }};
    }

    public static Stream<User> testUserProvider(){
        return Stream.of(
                new User("Vasya", "245", testUserHistoryProvider()),
                new User("Vasya1", "245", testUserHistoryProvider()),
                new User("Vasya2", "245", testUserHistoryProvider())
        );
    }

    @Test
    public void searchInStatementTest(){
        this.dataBase.setBaseOfCars(testCarProvider().toList());
        this.dataBase.setBaseOfUsers(testUserProvider().toList());

        var result = this.dataBase.SearchInStatement();

        assertEquals(3, result);
    }
}
