package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface SpeakerJPARepository extends JpaRepository<Speaker, Long> {

    List<Speaker> findByFirstNameAndLastName(String firstName, String lastName);

    List<Speaker> findByFirstNameOrLastName(String firstName, String lastName);

    List<Speaker> findBySpeakerPhotoIsNull();

    List<Speaker> findByCompanyIn(Collection<String> companies);

    List<Speaker> findByCompanyStartingWithIgnoreCase(String company);

    List<Speaker> findByLastNameOrderByFirstNameAsc(String lastName);

    Speaker findFirstByFirstName(String firstName);

}
