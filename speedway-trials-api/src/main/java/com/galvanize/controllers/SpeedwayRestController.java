package com.galvanize.controllers;

import com.galvanize.entities.Driver;
import com.galvanize.services.SpeedwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/speedway")
public class SpeedwayRestController {
    SpeedwayService speedwayService;

    @Autowired
    public SpeedwayRestController(SpeedwayService speedwayService) {
        this.speedwayService = speedwayService;
    }

    @PostMapping("/driver")
    public Driver createDriver(@RequestBody Driver driver) {
        return speedwayService.createDriver(driver);
    }

    @GetMapping("/driver/{id}")
    public Driver findDriver(@PathVariable Long id) {
        return speedwayService.findDriverById(id);
    }

    @GetMapping("/driver")
    public List<Driver> findAllDrivers() {
        return speedwayService.findAllDrivers();
    }

}
