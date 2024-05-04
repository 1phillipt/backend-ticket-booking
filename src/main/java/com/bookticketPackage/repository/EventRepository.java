package com.bookticketPackage.repository;

import com.bookticketPackage.dto.EventDto;
import com.bookticketPackage.model.Event;
import jakarta.persistence.Transient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    @Query(value = "select e.event_date, e.event_time, e.event_id, e.name, v.name as venue_name,e.venue_id  " +
            "FROM event e " +
            "inner join venue v on e.venue_id = v.venue_id;", nativeQuery = true)
    List<Event> getEventDetails();
}
