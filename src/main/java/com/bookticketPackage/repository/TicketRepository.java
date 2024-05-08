package com.bookticketPackage.repository;

import com.bookticketPackage.dto.TicketDto;
import com.bookticketPackage.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TicketRepository extends JpaRepository<Ticket,Long > {

    @Query(value = "SELECT * FROM ticket_booking.ticket where event_id =:eventId and seat_number=:seatNumber;", nativeQuery = true)
    TicketDto getByEventIdAndSeatNumber(long eventId, String seatNumber);
}
