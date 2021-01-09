package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TimeSlotJPARepository extends JpaRepository<TimeSlot, Long> {

    List<TimeSlot> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
