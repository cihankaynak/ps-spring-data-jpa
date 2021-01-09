package com.pluralsight.conferencedemo.models;

import com.pluralsight.conferencedemo.repositories.TicketTypeJPARepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class TicketTypeTest {

    @Autowired
    private TicketTypeJPARepository repository;

    @Test
    public void testFindByIncludesWorkshopTrue(){
        assertFalse( repository.findByIncludesWorkshopTrue().isEmpty() );
    }
}
