package com.company;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    Car car1 = new Car("Car",100,22111,true);
    Car car2 = new Car("Mustang",180,1000000,false);
    Car car3 = new Car("Car",100,22111,true);

    @Test
    void getName() {
        assertEquals("Car", car1.getName());
        assertEquals("Mustang", car2.getName());
    }

    @Test
    void getPower() {
        assertEquals(100,car1.getPower());
        assertEquals(180,car2.getPower());
    }

    @Test
    void getCost() {
        assertEquals(22111,car1.getCost());
        assertEquals(1000000,car2.getCost());
    }

    @Test
    void getServicable() {
        assertEquals(Boolean.TRUE,car1.getServicable());
        assertEquals(Boolean.FALSE,car2.getServicable());
    }

    @Test
    void setName() {
        car1.setName("New Name");
        assertEquals("New Name",car1.getName());
    }

    @Test
    void setPower() {
        car1.setPower(150);
        assertEquals(150,car1.getPower());
    }

    @Test
    void setCost() {
        car1.setCost(1600000);
        assertEquals(1600000,car1.getCost());
    }

    @Test
    void setServicable() {
        car1.setServicable(true);
        assertEquals(Boolean.TRUE,car1.getServicable());
    }

    @AfterClass
    void testToString() {
        assertEquals("Name: Car, Power: 100, Cost: 22111, Is it serviceable: true",car1.toString());
    }

    @BeforeClass
    void compareTo() {
        car1.mode = 1;
        assertEquals(-1,car1.compareTo(car2));
        assertEquals(0,car1.compareTo(car1));
        assertEquals(1,car2.compareTo(car1));
        car1.mode = 2;
        assertEquals(car1.getCost() - car2.getCost(),car1.compareTo(car2));
        assertEquals(car1.getCost() - car1.getCost(),car1.compareTo(car1));
        assertEquals(car2.getCost() - car1.getCost(),car2.compareTo(car1));
        car1.mode = 3;
        assertEquals(car1.getPower() - car2.getPower(),car1.compareTo(car2));
        assertEquals(car1.getPower() - car1.getPower(),car1.compareTo(car1));
        assertEquals(car2.getPower() - car1.getPower(),car2.compareTo(car1));
        car1.mode = 4;
        assertEquals(1,car1.compareTo(car2));
        assertEquals(0,car1.compareTo(car1));
        assertEquals(-1,car2.compareTo(car1));
    }
}