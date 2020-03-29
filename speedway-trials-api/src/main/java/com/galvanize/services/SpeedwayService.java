package com.galvanize.services;

import com.galvanize.entities.Car;
import com.galvanize.entities.Driver;
import com.galvanize.entities.Race;
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

    // LAH: One improvement here would be to have a separate service for each object type so they are
    // further decoupled. So DriverService interacts with the DriverRepository, CarService interacts with the
    // CarRepository...etc, which will also make it easier to mock those dependencies
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
        return createDriver(databaseDriver);
    }

    public void deleteDriverById(Long id) {
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
        return createCar(car);
    }

    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }

    public Race createRace(Race race) {
        return raceRepository.save(race);
    }

    public Race findRaceById(Long id) {
        return raceRepository.findById(id).orElse(null);
    }

    public List<Race> findAllRaces() {
        return raceRepository.findAll();
    }

    public Race updateRaceById(Long id, Race race) {
        Race databaseRace = findRaceById(id);
        databaseRace.update(race);
        return createRace(databaseRace);
    }

    public void deleteRaceById(Long id) {
        raceRepository.deleteById(id);
    }
}
