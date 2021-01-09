package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionJPARepository extends JpaRepository<Session, Long> {

    List<Session> findBySessionNameContains(String name);

    List<Session> findBySessionNameStartingWith(String name);

    List<Session> findBySessionLengthNot(Integer sessionLength);

    List<Session> findBySessionLengthLessThan(Integer length);

    List<Session> findBySessionNameNotLike(String name);

}
