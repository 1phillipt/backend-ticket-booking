package com.bookticketPackage.service;

import com.bookticketPackage.dto.EventDto;
import com.bookticketPackage.dto.VenueDto;
import com.bookticketPackage.mapper.EventMapper;
import com.bookticketPackage.model.Event;
import com.bookticketPackage.model.Venue;
import com.bookticketPackage.repository.EventRepository;
import com.bookticketPackage.repository.VenueRepository;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {

    private EventRepository eventRepository;
    private VenueRepository venueRepository;

    public EventService(EventRepository eventRepository, VenueRepository venueRepository) {
        this.eventRepository = eventRepository;
        this.venueRepository = venueRepository;
    }

    //saves event if not already exist
    public String save(EventDto eventDto) {

        Optional<Event> eventOptional = eventRepository.findById(eventDto.getEventId());

        if (eventOptional.isPresent()) {
            return "event already exist";
        } else {
            eventRepository.save(EventMapper.eventDtoToEvent(eventDto));
            return "Event Saved";
        }
    }

        //getEvents
    public List<EventDto> events() {

        List<EventDto> dtoList = eventRepository.getEventDetails().stream()
                .map(event ->EventMapper.eventToEventDto(event)).collect(Collectors.toList());//            List<EventDto> dtoList = eventRepository.getEventDetails().stream()
//                    .map(object ->EventMapper.eventToEventDto(new Event(object.getEventId(),object.getName(), object.getEventTime(), object.getEventDate(), object.getVenueName()))
//                    ).collect(Collectors.toList());
//        List<EventDto> eventDtos = eventRepository
//                .findAll()
//                .stream()
//                .map(Event -> EventMapper.eventToEventDto(Event))
//                .collect(Collectors.toList());

        return dtoList;
    }

    public EventDto getEventById(long id) {
        Optional<Event> optionalEventDto = eventRepository.findById(id);

        if (optionalEventDto.isPresent()) {
            return EventMapper.eventToEventDto(optionalEventDto.get());
        } else {
            throw new RuntimeException("Event Not Found");
        }

    }

    public String deleteEventById(long id) {
        if (eventRepository.findById(id).isPresent()) {
            eventRepository.deleteById(id);
            return "event deleted";
        } else {
            return "Event not found";
        }
    }

    public String updateEventById(long id, EventDto eventDto) {
        if (eventRepository.findById(id).isPresent()) {
            eventRepository.save(EventMapper.eventDtoToEvent(eventDto));
            return "event udpated";
        } else {
            return " event id not found";
        }
    }

    //saves events
    public String saveEvents(List<EventDto> listOfEventDtOs) {

        List<Event> ListOfEvent = listOfEventDtOs.stream().map(event -> EventMapper.eventDtoToEvent(event)).collect(Collectors.toList());
        System.out.println(ListOfEvent);

        eventRepository.saveAll(ListOfEvent);

        return "saved";
    }
}
