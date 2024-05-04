package com.bookticketPackage.service;

import com.bookticketPackage.dto.VenueDto;
import com.bookticketPackage.mapper.EventMapper;
import com.bookticketPackage.mapper.TicketMapper;
import com.bookticketPackage.mapper.VenueMapper;
import com.bookticketPackage.model.Event;
import com.bookticketPackage.model.Ticket;
import com.bookticketPackage.model.Venue;
import com.bookticketPackage.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VenueService {
    private VenueRepository venueRepository;

    public VenueService(VenueRepository venueRepository){
        this.venueRepository = venueRepository;
    }   
    
    public String save(VenueDto venueDto) {

       //Optional<Venue> venueOptional = venueRepository.findById(venueDto.getVanueID())
       if(venueRepository.findById(venueDto.getVanueId()).isPresent()){
           return "venue is already established";
       }else{
           venueRepository.save(VenueMapper.vanueDtoToVanue(venueDto));
           return "Venue saved";
       }
    }

    public List<VenueDto> getAllVenue() {
        return venueRepository.findAll().stream().map(venue -> VenueMapper.venueToVanueDto(venue)).collect(Collectors.toList());
    }


    public VenueDto getVenueById(long id) {
        Optional<Venue> optionalVenue = venueRepository.findById(id);
        if(optionalVenue.isPresent()){
           return VenueMapper.venueToVanueDto(optionalVenue.get());
        }else{
            throw new RuntimeException("vanue id not found");
        }
    }

    public String getVenueNameById(long id) {
        String name = venueRepository.findById(id).get().getName();
        return name;
        }


    public String deleteById(long id) {
        if(venueRepository.existsById(id)){
            venueRepository.deleteById(id);
            return "venue deleted";
        }else {
            return "venue not fund by given id";
        }
    }

    public String updateVenueById(long id, VenueDto venueDto) {
            Optional<Venue> optionalVenue = venueRepository.findById(id);
            if (optionalVenue.isPresent()) {
                venueRepository.save(VenueMapper.vanueDtoToVanue(venueDto));
                return "Venue Updated";
            } else {
                throw new RuntimeException("Venue id not found");
            }
        }

    public String saveVenues(List<VenueDto> venueDto) {
        System.out.println("saving");
        List<Venue> venues = venueDto.stream().map(Venue -> VenueMapper.vanueDtoToVanue(Venue)).collect(Collectors.toList());

        venueRepository.saveAll(venues);
        System.out.println("saved");
        return "Venues saved";
    }
}

