package com.bookticketPackage.controller;

import com.bookticketPackage.dto.SeatDto;
import com.bookticketPackage.model.Seat;
import com.bookticketPackage.service.SeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/seat")
public class SeatController {

    private SeatService seatService;

    public SeatController(SeatService seatService){
        this.seatService = seatService;
    }
    //save seat
    //http://localhost:8081/api/v1/seat
    @PostMapping
    public ResponseEntity<String> save(@RequestBody SeatDto seatDto){
        return ResponseEntity.ok().body(seatService.save(seatDto));
    }

    @PostMapping("/seats")
    public ResponseEntity<String> saveSeats(@RequestBody List<SeatDto> seatDto){
        return ResponseEntity.ok().body(seatService.saveSeats(seatDto));
    }
    //get all the seats that are available
    @GetMapping
    public ResponseEntity<List<SeatDto>> getAllSeats(){
        return ResponseEntity.ok().body(seatService.getAllSeats());
    }

    //get avialable seat by event id
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<SeatDto>> getAllSeats(@PathVariable("eventId") long eventId){
        return ResponseEntity.ok().body(seatService.getAllSeatsByEventId(eventId));
    }


    //get seat by seat id
    @GetMapping("/{id}")
    public ResponseEntity<SeatDto> seatById(@PathVariable("id") long id){
        return ResponseEntity.ok().body(seatService.seatById(id));
    }
    @GetMapping("/availableseats")
    public ResponseEntity<List<SeatDto>> getAllAvailableSeats(){
        return ResponseEntity.ok().body(seatService.getAllAvailableSeats());
    }

    //http://localhost:8081/api/v1/seat/seatAvailable/
    //is ticket avialble
    @GetMapping("/seatAvailibility/{id}")
    public ResponseEntity<Boolean>  isSeatAvailable(@PathVariable("id") long id){
        return ResponseEntity.ok().body(seatService.isSeatAvailable(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSeatById(@PathVariable("id") long id){
        return ResponseEntity.ok().body(seatService.deleteSeatById(id));
    }


    @DeleteMapping("/seatNumber/{seatNumber}")
    public ResponseEntity<String> deleteSeatBySeatNumber(@PathVariable("seatNumber") String seatNumber){
        return ResponseEntity.ok().body(seatService.deleteSeatBySeatNumber(seatNumber));
    }
}
