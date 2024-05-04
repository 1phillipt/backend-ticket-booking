package com.bookticketPackage.controller;

import com.bookticketPackage.dto.EventDto;
import com.bookticketPackage.dto.VenueDto;

import com.bookticketPackage.service.EventService;
import com.bookticketPackage.service.VenueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/event")
public class EventController {

    private EventService eventService;
    private VenueService venueService;

    public EventController(EventService eventService, VenueService venueService){
        this.venueService = venueService;
        this.eventService = eventService;
    }


    //saves a event
    @PostMapping
    public ResponseEntity<String> save(@RequestBody EventDto eventDto){
        return ResponseEntity.ok().body(eventService.save(eventDto));
    }

    @PostMapping("/events")
    public ResponseEntity<String> saveEvents(@RequestBody List<EventDto> listOfEventDtos){
        return ResponseEntity.ok().body(eventService.saveEvents(listOfEventDtos));
    }
    //gets all the events available
    @GetMapping()
    public ResponseEntity<List<EventDto>> events(){
        return ResponseEntity.ok().body(eventService.events());
    }
    //get event by id
    @GetMapping("/{id}")
    public ResponseEntity<EventDto> events(@PathVariable("id") long id){
        return ResponseEntity.ok().body(eventService.getEventById(id));
    }
    //delete event by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteEventById(@PathVariable("id") long id){
        return ResponseEntity.ok().body(eventService.deleteEventById(id));
    }
    @PatchMapping
    public ResponseEntity<String> updateEventById(@PathVariable("id") long id, @RequestBody EventDto eventDto){
        return ResponseEntity.ok().body(eventService.updateEventById(id, eventDto));
    }
//    @GetMapping("/{venueid}")
//    public ResponseEntity<String> getVenueNameByVenueId(@PathVariable("id") long id){
//        return ResponseEntity.ok().body(venueService.getVenueNameById(id));
//    }
}
