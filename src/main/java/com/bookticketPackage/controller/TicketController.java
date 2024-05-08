package com.bookticketPackage.controller;

import com.bookticketPackage.dto.TicketDto;
import com.bookticketPackage.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/ticket")
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    //saves newly created ticket
    @PostMapping
    public ResponseEntity<String> save(@RequestBody TicketDto ticketDto){
        System.out.println("inside ticket controller's save ticket method");
        return ResponseEntity.ok().body(ticketService.save(ticketDto));
    }
    @GetMapping
    public ResponseEntity<List<TicketDto>> getAllTickets(){
        return ResponseEntity.ok().body(ticketService.getAllTickets());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getByTicketId(@PathVariable("id") long id){
        return ResponseEntity.ok().body(ticketService.getByTicketId(id));
    }

    //returns tickets by event and seatId
    @GetMapping("/{eventId}/{seatNumber}")
    public ResponseEntity<TicketDto> getByTicketEventIdAndseatNumber(@PathVariable("eventId") long eventId, @PathVariable("seatNumber") String seatNumber){
        System.out.println("inside getmapping ticket controller by eventid and seatNumber   "+ seatNumber + "event id "+ eventId);
        return ResponseEntity.ok().body(ticketService.getByEventIdAndSeatNumber(eventId,seatNumber));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String>   deleteTicketById(@PathVariable("id") long id){
        return ResponseEntity.ok().body(ticketService.deleteTicketById(id));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateTicketByid(@PathVariable("id") long id, @RequestBody TicketDto ticketDto){
        return ResponseEntity.ok().body(ticketService.updateTicketById(id, ticketDto));
    }

}
