package com.bookticketPackage.mapper;

import com.bookticketPackage.dto.SeatDto;
import com.bookticketPackage.dto.TicketDto;
import com.bookticketPackage.model.*;
import com.bookticketPackage.repository.SeatsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TicketMapper {
//    private long ticketId;
//    private long eventId;
//    private long customerId;
//    private long seatId;
//    private long paymentInfoId;
    public static TicketDto ticketToTicketDto(Ticket ticket){
        return TicketDto.builder()
                .ticketId(ticket.getTicketId())
                .eventId(ticket.getEventId())
                .customerId(ticket.getCustomerId())
                .paymentInfoId(ticket.getPaymentInfoId())
                .build();
    }

    public static Ticket ticketDtoToTicket(TicketDto ticketDto){
        return Ticket.builder()
                .ticketId(ticketDto.getTicketId())
                .eventId(ticketDto.getEventId())
                .customerId(ticketDto.getCustomerId())
                .seatId(ticketDto.getSeatId())
                .paymentInfoId(ticketDto.getPaymentInfoId())
                .build();
    }

}
