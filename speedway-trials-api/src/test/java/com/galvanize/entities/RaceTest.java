package com.galvanize.entities;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RaceTest {
    @Test
    void updateRace(){
        Race expected = new Race();
        Race actual = new Race();
        expected.setId(1L);
        actual.update(expected);
        assertEquals(expected, actual);
    }
}
