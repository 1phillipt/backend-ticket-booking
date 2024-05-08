package com.bookticketPackage.service;

import com.bookticketPackage.dto.TicketDto;
import com.bookticketPackage.mapper.TicketMapper;
import com.bookticketPackage.model.Ticket;
import com.bookticketPackage.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }


    //save tickets
    public String save(TicketDto ticketDto) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketDto.getTicketId());

        if(optionalTicket.isPresent()){
            return "user already exist";
        }else{
            ticketRepository.save(TicketMapper.ticketDtoToTicket(ticketDto));


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

    public TicketDto getByTicketId(long id) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        if(optionalTicket.isPresent()){
            return TicketMapper.ticketToTicketDto(optionalTicket.get());
        }else{
            throw new RuntimeException("ticket id not found");
        }
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
