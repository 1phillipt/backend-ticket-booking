package com.bookticketPackage.mapper;

import com.bookticketPackage.dto.VenueDto;
import com.bookticketPackage.model.Venue;

public class VenueMapper {

    public static Venue vanueDtoToVanue(VenueDto venueDto){
        return Venue.builder()
                .name(venueDto.getName())
                .address(venueDto.getAddress())
                .venueId(venueDto.getVanueId())
                .capacity(venueDto.getCapacity()).build();
    }

    public static VenueDto  venueToVanueDto(Venue venue){
        return VenueDto.builder()
                .vanueId(venue.getVenueId())
                .address(venue.getAddress())
                .name(venue.getName())
                .capacity(venue.getCapacity()).build();
    }
}
