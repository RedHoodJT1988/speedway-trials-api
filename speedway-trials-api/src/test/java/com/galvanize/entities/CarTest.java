package com.galvanize.entities;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

// LAH: This test is not needed since this functionality is already
// included in the JpaRepository
@SpringBootTest
public class CarTest {
    @Test
    void updateCar(){
        Car expected = new Car();
        expected.setId(1L);
        Car actual = new Car();
        actual.update(expected);
        assertEquals(expected, actual);
    }
}
