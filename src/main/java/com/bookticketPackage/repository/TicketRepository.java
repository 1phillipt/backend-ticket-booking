package com.bookticketPackage.repository;

import com.bookticketPackage.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long > {
}
