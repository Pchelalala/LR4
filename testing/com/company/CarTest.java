package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void getNameTest() {
        var car = new Car("Car",100,22111,true);

        assertEquals("Car", car.getName());
        assertNotEquals("car", car.getName());
    }

    @Test
    void getPowerTest() {
        var car = new Car("Car",100,22111,true);

        assertEquals(100,car.getPower());
        assertNotEquals(180,car.getPower());
    }

    @Test
    void getCostTest() {
        var car = new Car("Car",100,22111,true);

        assertEquals(22111,car.getCost());
        assertNotEquals(1000000,car.getCost());
    }

    @Test
    void getServicableTest() {
        var car = new Car("Car",100,22111,true);

        assertTrue(car.getServicable());
        assertNotEquals(Boolean.FALSE,car.getServicable());
    }

    @Test
    void setNameTest() {
        var car = new Car("Car",100,22111,true);

        car.setName("New Name");
        assertEquals("New Name",car.getName());
    }

    @Test
    void setPowerTest() {
        var car = new Car("Car",100,22111,true);

        car.setPower(150);
        assertEquals(150,car.getPower());
    }

    @Test
    void setCostTest() {
        var car = new Car("Car",100,22111,true);

        car.setCost(1600000);
        assertEquals(1600000,car.getCost());
    }

    @Test
    void setServicableTest() {
        var car = new Car("Car",100,22111,true);

        car.setServicable(true);
        assertEquals(Boolean.TRUE,car.getServicable());
    }

    @Test
    void compareToByNameTest(){
        Car.mode = 1;

        var car = new Car("Car",100,22111,true);
        var car1 = new Car("Car",180,1000000,false);
        assertEquals(car.compareTo(car1), 1);
    }
}
