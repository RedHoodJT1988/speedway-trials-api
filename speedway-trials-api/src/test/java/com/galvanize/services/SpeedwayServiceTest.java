package com.galvanize.services;

import com.galvanize.entities.Car;
import com.galvanize.entities.Driver;
import com.galvanize.entities.Race;
import com.galvanize.entities.Status;
import com.galvanize.repositories.CarRepository;
import com.galvanize.repositories.DriverRepository;
import com.galvanize.repositories.RaceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
        // LAH: It's also a good practice to vary your test data, so a diferent name and age
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
        speedwayService.updateDriverById(expected, expected.getId());
        assertEquals(expected, speedwayService.findDriverById(expected.getId()));
    }

    @Test
    void deleteDriverById(){
        SpeedwayService speedwayService = new SpeedwayService(driverRepository, carRepository, raceRepository);
        Driver expected = speedwayService.createDriver(new Driver("Paul", "Bethany", 55, "Vision"));
        speedwayService.deleteDriverById(expected.getId());
        assertNull(speedwayService.findDriverById(expected.getId()));
    }

    @Test
    void createCar(){
        SpeedwayService speedwayService = new SpeedwayService(driverRepository, carRepository, raceRepository);
        Car expected = new Car("Bullet", "Mustang", 2200, 53, Status.AVAILABLE, 200);

        assertEquals(expected, speedwayService.createCar(expected));
    }

    @Test
    void findCarById(){
        SpeedwayService service = new SpeedwayService(driverRepository, carRepository, raceRepository);
        Car expected = service.createCar(new Car("Bullet", "Mustang", 2200, 53, Status.AVAILABLE, 200));
        assertEquals(expected, service.findCarById(expected.getId()));
    }

    @Test
    void findAllCars(){
        SpeedwayService speedwayService = new SpeedwayService(driverRepository, carRepository, raceRepository);
        Car expected = speedwayService.createCar(new Car("Bullet", "Mustang", 2200, 53, Status.AVAILABLE, 200));
        List<Car> expectedCars = new ArrayList<>();
        expectedCars.add(expected);
        assertEquals(expectedCars, speedwayService.findAllCars());
    }

    @Test
    void updateCarById(){
        SpeedwayService speedwayService = new SpeedwayService(driverRepository, carRepository, raceRepository);
        Car expected = speedwayService.createCar(new Car("Bullet", "Mustang", 2200, 53, Status.AVAILABLE, 200));
        expected.setNickName("Different Nickname");
        assertEquals(expected, speedwayService.updateCarById(expected.getId(), expected));
    }

    @Test
    void deleteCarByID(){
        SpeedwayService speedwayService = new SpeedwayService(driverRepository, carRepository, raceRepository);
        Car carToBeDeleted = speedwayService.createCar(new Car("Bullet", "Mustang", 2200, 53, Status.AVAILABLE, 200));
        speedwayService.deleteCarById(carToBeDeleted.getId());
        assertNull(speedwayService.findCarById(carToBeDeleted.getId()));
    }

    @Test
    void createRace(){
        SpeedwayService speedwayService = new SpeedwayService(driverRepository, carRepository, raceRepository);
        Race race = new Race("Grand Prix", "Finals", LocalDate.now(), "00:00:01", 404L, new ArrayList<>());
        Race actualRace = speedwayService.createRace(race);
        race.setId(actualRace.getId());
        assertEquals(race, actualRace);
    }

    @Test
    void findRaceById(){
        SpeedwayService speedwayService = new SpeedwayService(driverRepository, carRepository, raceRepository);
        Race expected = speedwayService.createRace(new Race("Grand Prix", "Finals", LocalDate.now(), "00:00:01", 404L, new ArrayList<>()));
        assertEquals(expected, speedwayService.findRaceById(expected.getId()));
    }

    @Test
    void findAllRaces(){
        SpeedwayService speedwayService = new SpeedwayService(driverRepository, carRepository, raceRepository);
        Race expected = speedwayService.createRace(new Race("Grand Prix", "Finals", LocalDate.now(), "00:00:01", 404L, new ArrayList<>()));
        List<Race> expectedRaces = new ArrayList<>();
        expectedRaces.add(expected);
        assertEquals(expectedRaces, speedwayService.findAllRaces());
    }

    @Test
    void updateRaceById(){
        SpeedwayService speedwayService = new SpeedwayService(driverRepository, carRepository, raceRepository);
        Race expected = speedwayService.createRace(new Race("Grand Prix", "Finals", LocalDate.now(), "00:00:01", 404L, new ArrayList<>()));
        expected.setBestTime("00:00:00");
        assertEquals(expected, speedwayService.updateRaceById(expected.getId(), expected));
    }

    @Test
    void deleteRaceById(){
        SpeedwayService speedwayService = new SpeedwayService(driverRepository, carRepository, raceRepository);
        Race expected = speedwayService.createRace(new Race("Grand Prix", "Finals", LocalDate.now(), "00:00:01", 404L, new ArrayList<>()));
        speedwayService.deleteRaceById(expected.getId());
        assertNull(speedwayService.findRaceById(expected.getId()));
    }
}
