package com.bookticketPackage.mapper;

import com.bookticketPackage.dto.SeatDto;
import com.bookticketPackage.dto.TicketDto;
import com.bookticketPackage.model.Customer;
import com.bookticketPackage.model.Event;
import com.bookticketPackage.model.Seat;
import com.bookticketPackage.model.Ticket;
import com.bookticketPackage.repository.SeatsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TicketMapper {

    public static TicketDto ticketToTicketDto(Ticket ticket){
        return TicketDto.builder()
                .ticketId(ticket.getTicketId())
                .eventId(ticket.getEvent().getEventId())
                //.customerID(ticket.getCustomer().getCustomerId())
                .build();
    }

    public static Ticket ticketDtoToTicket(TicketDto ticketDto){
        return Ticket.builder()
                .ticketId(ticketDto.getTicketId())
                .event(Event.builder().eventId(ticketDto.getEventId()).build())
                //.customer(Customer.builder().customerId(ticketDto.getCustomerID()).build())
                .build();
    }

}
