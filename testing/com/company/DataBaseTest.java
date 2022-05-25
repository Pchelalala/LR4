package com.company;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataBaseTest {
    private DataBase dataBase;
    @Before
    public void initialize(){
        dataBase = new DataBase();
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
                new Car("Car",100,22111,true)
        );
    }
}
