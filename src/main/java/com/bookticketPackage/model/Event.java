package com.bookticketPackage.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;



import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@ToString
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long eventId;

    @Transient
    private long venueId;

    private String name;

    private String venueName;

    @Column
    private LocalDate eventDate; // Maps to SQL DATE

    @Column
    private LocalTime eventTime; // Maps to SQL TIME

    @OneToOne(optional = false)
    @JoinColumn(name = "venue_id", nullable = false)
    private Venue venue;


    public Event(long eventId, String name, LocalTime eventTime, LocalDate eventDate, String venueName) {
        this.eventId = eventId;
        this.name = name;
        this.eventTime = eventTime;
        this.eventDate = eventDate;
        this.venueName = venueName;
    }
}

