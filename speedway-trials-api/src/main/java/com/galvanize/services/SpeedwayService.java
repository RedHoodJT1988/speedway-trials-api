package com.galvanize.services;

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

    public Driver update(Driver expected, Long id) {
        Driver databaseDriver = findDriverById(id);
        databaseDriver.update(expected);
        return driverRepository.save(databaseDriver);
    }

    public void deleteById(Long id) {
        driverRepository.deleteById(id);
    }
}
