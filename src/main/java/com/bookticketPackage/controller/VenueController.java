package com.bookticketPackage.controller;

import com.bookticketPackage.dto.TicketDto;
import com.bookticketPackage.dto.VenueDto;
import com.bookticketPackage.model.Venue;
import com.bookticketPackage.service.VenueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/venue")
public class VenueController {
    private VenueService venueService;

    public VenueController(VenueService venueService){
        this.venueService = venueService;
    }

    //save a venue
    @PostMapping
    public ResponseEntity<String> save(@RequestBody VenueDto venueDto){
     return ResponseEntity.ok().body(venueService.save(venueDto));
    }

    //save multiple venues

    @PostMapping("/venues")
    public ResponseEntity<String> saveVenues(@RequestBody List<VenueDto> venueDto){
        System.out.println("calling");
        return ResponseEntity.ok().body(venueService.saveVenues(venueDto));
    }

    //get all venue
    @GetMapping
    public ResponseEntity<List<VenueDto>> getAllVenue(){
        return ResponseEntity.ok().body(venueService.getAllVenue());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VenueDto> getVenueById(@PathVariable("id") long id){
        return ResponseEntity.ok().body(venueService.getVenueById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVenueById(@PathVariable("id") long id){
        return ResponseEntity.ok().body(venueService.deleteById(id));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateVenueById(@PathVariable("id") long id, @RequestBody VenueDto venueDto){
        return ResponseEntity.ok().body(venueService.updateVenueById(id, venueDto));
    }
}
