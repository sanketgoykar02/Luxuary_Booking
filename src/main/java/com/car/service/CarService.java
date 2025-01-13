package com.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.entity.Car;
import com.car.repository.CarRepository;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public String saveCar(Car car) {
        carRepository.save(car);
        return "Car Successfuly saved";
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }
}

