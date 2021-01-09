package com.pluralsight.conferencedemo.models;

import com.pluralsight.conferencedemo.repositories.TimeSlotJPARepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class TimeSlotTest {

    @Autowired
    private TimeSlotJPARepository repository;

    @Test
    public void testFindAll(){
        assertFalse( repository.findAll().isEmpty() );
    }

    @Test
    public void testFindByDateBetween(){
        assertEquals(5, repository.findByDateBetween(LocalDate.of(2020, 4, 10), LocalDate.of(2020, 4, 11)).size());
    }
}
