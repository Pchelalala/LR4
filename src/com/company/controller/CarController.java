package com.company.controller;

import com.company.DB.CarJDBCDao;
import com.company.dto.CarInsertDto;
import com.company.model.Car;

import java.util.List;

public class CarController {
    private CarJDBCDao carJDBCDao;

    public CarController(CarJDBCDao carJDBCDao) {
        this.carJDBCDao = carJDBCDao;
    }
    public boolean insert(CarInsertDto carInsertDto){
        Car car = new Car(carInsertDto.name, carInsertDto.power, carInsertDto.cost);
        return carJDBCDao.insert(car);
    }

    public List<Car> getAllCar(){
        return carJDBCDao.getAll();
    }
    public boolean updateCar(Car car){
        return carJDBCDao.update(car);
    }

}
