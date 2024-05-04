package com.bookticketPackage.dto;

import lombok.*;

import java.sql.Time;
import java.sql.Date;

import lombok.Builder;

@Data
@Builder
@ToString
public class EventDto {
    private long eventId;
    private String name;
    private Date eventDate;
    private Time eventTime;
    private long venueId;
    private String venueName;

}
