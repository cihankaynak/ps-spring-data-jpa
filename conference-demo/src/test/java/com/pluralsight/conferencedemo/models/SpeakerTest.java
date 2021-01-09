package com.pluralsight.conferencedemo.models;

import com.pluralsight.conferencedemo.repositories.SpeakerJPARepository;
import com.pluralsight.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SpeakerTest {
    @Autowired
    private SpeakerJPARepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testFind() throws Exception {
        Speaker speaker = repository.getOne(1L);
        assertNotNull(speaker);
    }

    @Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception {
        Speaker s = new Speaker();
        s.setCompany("Pluralsight");
        s.setFirstName("Dan");
        s.setLastName("Bunker");
        s.setTitle("Author");
        s.setSpeakerBio("Consulting and mentoring");
        s = repository.saveAndFlush(s);

        // clear the persistence context so we don't return the previously cached location object
        // this is a test only thing and normally doesn't need to be done in prod code
        entityManager.clear();

        Speaker otherSpeaker = repository.getOne(s.getSpeakerId());
        assertEquals("Dan", otherSpeaker.getFirstName());

        repository.deleteById(otherSpeaker.getSpeakerId());
    }

    @Test
    public void testFindByFirstNameAndLastName(){
        assertFalse(repository.findByFirstNameAndLastName("Justin", "Clark").isEmpty());
    }

    @Test
    public void testFindByFirstNameOrLastName(){
        assertFalse(repository.findByFirstNameOrLastName("Justin", "Clark").isEmpty());
    }

    @Test
    public void testFindBySpeakerPhotoIsNull(){
        assertFalse(repository.findBySpeakerPhotoIsNull().isEmpty());
    }

    @Test
    public void testFindByCompanyIn(){
        assertEquals(2, repository.findByCompanyIn(Arrays.asList("Bank Europe", "Big Data Consulting")).size());
    }

    @Test
    public void testFindByCompany(){
        assertEquals(3, repository.findByCompanyStartingWithIgnoreCase("cLoUd").size());
    }

    @Test
    public void testFindByLastNameOrderByFirstName(){
        assertEquals(3, repository.findByCompanyStartingWithIgnoreCase("cLoUd").size());
    }

    @Test
    public void testFindFirstByFirstName(){
        assertNotNull(repository.findFirstByFirstName("James"));
    }

}
