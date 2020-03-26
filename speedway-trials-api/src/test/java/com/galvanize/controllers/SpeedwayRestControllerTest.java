package com.galvanize.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.entities.Driver;
import com.galvanize.services.SpeedwayService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class SpeedwayRestControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    SpeedwayService speedwayService;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void createDriver() throws Exception {
        Driver driver = new Driver();
        String json = objectMapper.writeValueAsString(driver);
        driver.setId(1L);
        when(speedwayService.createDriver(ArgumentMatchers.any(Driver.class))).thenReturn(driver);
        mockMvc.perform(post("/api/speedway/driver").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(driver.getId()));
    }

    @Test
    void findDriver() throws Exception {
        Driver driver = new Driver();
        driver.setId(1L);
        when(speedwayService.findDriverById(1L)).thenReturn(driver);
        mockMvc.perform(get("/api/speedway/driver/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(driver.getId()));
    }

    @Test
    void findAllDrivers() throws Exception {
        List<Driver> drivers = new ArrayList<>();
        Driver driver = new Driver();
        drivers.add(driver);
        when(speedwayService.findAllDrivers()).thenReturn(drivers);
        mockMvc.perform(get("/api/speedway/driver"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

//    @Test
//    void updateDriverById() throws Exception{
//        Driver expected = new Driver();
//        String json = objectMapper.writeValueAsString(expected);
//        expected.setId(1L);
//
//        when(speedwayService.update(1L,ArgumentMatchers.any(Driver.class))).thenReturn(expected);
//
//        mockMvc.perform(put("/api/speedway/driver/1").content(json).contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(expected.getId()));
//    }
}