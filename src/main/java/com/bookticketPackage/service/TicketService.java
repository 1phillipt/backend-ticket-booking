package com.bookticketPackage.service;

import com.bookticketPackage.dto.ConfirmationDto;
import com.bookticketPackage.dto.TicketDto;
import com.bookticketPackage.mapper.TicketMapper;
import com.bookticketPackage.model.Confirmation;
import com.bookticketPackage.model.Ticket;
import com.bookticketPackage.repository.TicketRepository;
import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketService {
    LocalDate currentDate = LocalDate.now();
    private TicketRepository ticketRepository;
    private ConfirmationService confirmationService;

    public TicketService(TicketRepository ticketRepository, ConfirmationService confirmationService){
        this.confirmationService = confirmationService;
        this.ticketRepository = ticketRepository;
    }


    //save tickets
    public String save(TicketDto ticketDto) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketDto.getTicketId());

        if(optionalTicket.isPresent()){
            return "user already exist";
        }else{
            ticketRepository.save(TicketMapper.ticketDtoToTicket(ticketDto));

            //saves confimation when new ticket is created
            confirmationService.save(ConfirmationDto.builder().ticketId(ticketDto.getTicketId()).customerId(ticketDto.getCustomerId()).confirmationDate(currentDate).build());

        }
        ticketRepository.setSeatAvailableToNone(ticketDto.getSeatNumber());
        return "Ticket created";
    }

    public List<TicketDto> getAllTickets() {
        return ticketRepository.findAll()
                .stream()
                .map(ticket -> TicketMapper.ticketToTicketDto(ticket))
                .collect(Collectors.toList());
    }

    public List<TicketDto> getTicketBycustomerId(long customerId) {
        return ticketRepository.findByCustomerID(customerId).stream().map(ticket -> TicketMapper.ticketToTicketDto(ticket)).collect(Collectors.toList());
    }

    public String deleteTicketById(long id) {
        if(ticketRepository.existsById(id)){
            ticketRepository.deleteById(id);
            return "ticket deleted";
        }else {
            return "ticket Id not found";
        }
    }

    public String updateTicketById(long id, TicketDto ticketDto) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        if (optionalTicket.isPresent()) {
            ticketRepository.save(TicketMapper.ticketDtoToTicket(ticketDto));
            return "ticket Updated";
        } else {
                throw new RuntimeException("ticket id not found");
        }
    }

    public TicketDto getByEventIdAndSeatNumber(long eventId, String seatNumber) {
        return TicketMapper.ticketToTicketDto(ticketRepository.findByEventIdAndSeatNumber(eventId,seatNumber));
    }
}
