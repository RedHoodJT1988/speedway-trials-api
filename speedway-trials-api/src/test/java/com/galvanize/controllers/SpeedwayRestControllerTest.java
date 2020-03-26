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
        mockMvc.perform(post("api/service/driver").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(driver.getId()));
    }
}