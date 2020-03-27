package com.galvanize.services;

import com.galvanize.entities.Car;
import com.galvanize.entities.Driver;
import com.galvanize.entities.Status;
import com.galvanize.repositories.CarRepository;
import com.galvanize.repositories.DriverRepository;
import com.galvanize.repositories.RaceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class SpeedwayServiceTest {
    @Autowired
    DriverRepository driverRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    RaceRepository raceRepository;

    @Test
    void createDriver() {
        SpeedwayService speedwayService = new SpeedwayService(driverRepository, carRepository, raceRepository);
        Driver driver = new Driver("Jimmy", "Blart", 500, "Mall Cop");
        Driver actual = speedwayService.createDriver(driver);
        driver.setWin(0);
        driver.setLoss(0);

        assertEquals(driver, actual);
    }

    @Test
    void findDriverById() {
        SpeedwayService speedwayService = new SpeedwayService(driverRepository, carRepository, raceRepository);
        Driver expected = speedwayService.createDriver(new Driver("Paul", "Bethany", 55, "Vision"));
        assertEquals(expected, speedwayService.findDriverById(expected.getId()));
    }

    @Test
    void findAllDrivers() {
        SpeedwayService speedwayService = new SpeedwayService(driverRepository, carRepository, raceRepository);
        Driver expected = speedwayService.createDriver(new Driver("Paul", "Bethany", 55, "Vision"));
        List<Driver> drivers = new ArrayList<>();
        drivers.add(expected);
        assertEquals(drivers, speedwayService.findAllDrivers());
    }

    @Test
    void updateDriverById(){
        SpeedwayService speedwayService = new SpeedwayService(driverRepository, carRepository, raceRepository);
        Driver expected = speedwayService.createDriver(new Driver("Paul", "Bethany", 55, "Vision"));
        expected.setLastName("Blart");
        speedwayService.updateDriver(expected, expected.getId());
        assertEquals(expected, speedwayService.findDriverById(expected.getId()));
    }

    @Test
    void deleteDriverById(){
        SpeedwayService speedwayService = new SpeedwayService(driverRepository, carRepository, raceRepository);
        Driver expected = speedwayService.createDriver(new Driver("Paul", "Bethany", 55, "Vision"));
        speedwayService.deleteById(expected.getId());
        assertNull(speedwayService.findDriverById(expected.getId()));
    }

    @Test
    void createCar(){
        SpeedwayService speedwayService = new SpeedwayService(driverRepository, carRepository, raceRepository);
        Car expected = new Car("Bullet", "Mustang", 2200, 53, Status.AVAILABLE, 200);

        assertEquals(expected, speedwayService.createCar(expected));
    }
}
