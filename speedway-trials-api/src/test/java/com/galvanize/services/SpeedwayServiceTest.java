package com.galvanize.services;

import com.galvanize.entities.Driver;
import com.galvanize.repositories.CarRepository;
import com.galvanize.repositories.DriverRepository;
import com.galvanize.repositories.RaceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

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


}
