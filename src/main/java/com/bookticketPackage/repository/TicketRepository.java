package com.bookticketPackage.repository;

import com.bookticketPackage.dto.TicketDto;
import com.bookticketPackage.model.Ticket;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TicketRepository extends JpaRepository<Ticket,Long > {

    @Query(value = "SELECT * FROM  ticket_booking.ticket WHERE event_Id =:eventId AND seat_number =:seatNumber", nativeQuery = true)
    Ticket findByEventIdAndSeatNumber(@Param("eventId") long eventId, @Param("seatNumber") String seatNumber);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Seat s SET s.available = 0 WHERE s.seatNumber = :seatNumber")
    void setSeatAvailableToNone(String seatNumber);

}
