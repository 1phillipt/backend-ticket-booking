package com.bookticketPackage.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.TrueFalseConverter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seatId;
    private String seatNumber;
    private double price;
    private int available;

    @ManyToOne(optional = false)
    @JoinColumn(name = "eventId",nullable = false)
    private Event event;



//    @ManyToOne(optional = false)
//    @JoinColumn(name = "ticketId", nullable = false)
//    private Ticket ticket;



//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ticket_id ", referencedColumnName = "ticketId")
//    private Ticket ticket;
//    @Transient
//    private List<String> seatNumber = new ArrayList<>();

}
