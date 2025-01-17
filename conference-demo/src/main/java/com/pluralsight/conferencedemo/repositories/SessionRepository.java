package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SessionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SessionJPARepository sessionJPARepository;

    public Session create(Session session) {
        return update(session);
    }

    public Session update(Session session) {
        return sessionJPARepository.saveAndFlush(session);
    }

    public void delete(Long id) {
        sessionJPARepository.deleteById(id);
    }

    public Session find(Long id) {
        return sessionJPARepository.findById(id).orElse(null);
    }

    public List<Session> list() {
        return sessionJPARepository.findAll();
    }

    public List<Session> getSessionsThatHaveName(String name) {
        return sessionJPARepository.findBySessionNameContains(name);
    }
}
