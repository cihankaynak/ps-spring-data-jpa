package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketTypeJPARepository extends JpaRepository<TicketType, String> {

    List<TicketType> findByIncludesWorkshopTrue();
}
