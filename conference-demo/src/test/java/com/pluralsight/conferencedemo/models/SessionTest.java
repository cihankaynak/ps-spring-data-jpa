package com.pluralsight.conferencedemo.models;

import com.pluralsight.conferencedemo.repositories.SessionJPARepository;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SessionTest {
    @Autowired
    private SessionRepository repository;

    @Autowired
    private SessionJPARepository jpaRepository;

    @Test
    public void test() throws Exception {
        List<Session> sessions = repository.getSessionsThatHaveName("Java");
        assertTrue(sessions.size() > 0);
    }

    @Test
    public void testSessionLengthNot(){
        assertFalse( jpaRepository.findBySessionLengthNot(30).isEmpty() );
    }

    @Test
    public void testSessionLengthLessThan(){
        assertFalse( jpaRepository.findBySessionLengthLessThan(45).isEmpty() );
    }

    @Test
    public void testSessionNameNotLike(){
        assertFalse( jpaRepository.findBySessionNameNotLike("Java%").isEmpty() );
    }

    @Test
    public void testSessionNameStartingWith(){
        assertFalse( jpaRepository.findBySessionNameStartingWith("Spring").isEmpty() );
    }

}
