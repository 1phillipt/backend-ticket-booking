package com.bookticketPackage.mapper;

import com.bookticketPackage.dto.EventDto;
import com.bookticketPackage.model.Customer;
import com.bookticketPackage.model.Event;
import com.bookticketPackage.model.Venue;
import org.springframework.validation.annotation.ValidationAnnotationUtils;

import java.sql.Date;
import java.sql.Time;


public class EventMapper {

    public static Event eventDtoToEvent(EventDto eventDto){
        return Event.builder()
                .eventId(eventDto.getEventId())
                .name(eventDto.getName())
                .eventDate(eventDto.getEventDate().toLocalDate())
                .eventTime(eventDto.getEventTime().toLocalTime())
                .venue(Venue.builder().venueId(eventDto.getVenueId()).build())
                .build();

    }
    public static EventDto eventToEventDto(Event event){
        return EventDto.builder()
                .eventId(event.getEventId())
                .name(event.getName())
                .eventDate(Date.valueOf(event.getEventDate()))
                .eventTime(Time.valueOf(event.getEventTime()))
                .venueName(event.getVenueName())
                .venueId(event.getVenue().getVenueId())
                .build();
    }
}
