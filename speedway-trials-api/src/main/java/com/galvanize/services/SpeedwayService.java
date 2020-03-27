package com.galvanize.services;

import com.galvanize.entities.Car;
import com.galvanize.entities.Driver;
import com.galvanize.repositories.CarRepository;
import com.galvanize.repositories.DriverRepository;
import com.galvanize.repositories.RaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeedwayService {
    RaceRepository raceRepository;
    CarRepository carRepository;
    DriverRepository driverRepository;

    public SpeedwayService(DriverRepository driverRepository, CarRepository carRepository, RaceRepository raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver findDriverById(long l) {
        return driverRepository.findById(l).orElse(null);
    }

    public List<Driver> findAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver updateDriverById(Driver expected, Long id) {
        Driver databaseDriver = findDriverById(id);
        databaseDriver.update(expected);
        return driverRepository.save(databaseDriver);
    }

    public void deleteById(Long id) {
        driverRepository.deleteById(id);
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Car findCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public Car updateCarById(Long id, Car car) {
        Car databaseCar = findCarById(id);
        databaseCar.update(car);
        return carRepository.save(car);
    }
}
