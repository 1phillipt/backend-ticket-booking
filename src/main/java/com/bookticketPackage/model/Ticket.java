package com.bookticketPackage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ticketId;

    private long eventId;
    private long customerId;
    private long seatId;
    private long paymentInfoId;

//    @ManyToOne(optional = false)
//    @JoinColumn(name ="Event_Id", nullable = false)
//    private Event event;
//
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "customerId", nullable = false)
//    private Customer customer;
//
//    @ManyToOne
//    @JoinColumn(name = "seat_id", nullable = false)
//    private Seat seat; //this should have ticket having seat column in the table



//    @ManyToOne(optional = false)
//    @JoinColumn(name = "payment_Info_Id", nullable = false)
//    private PaymentInfo paymentInfo;//this makes the column payment_info_id in ticket and establish relationship


//    @OneToMany(cascade = CascadeType.ALL) // mappedBy refers to the field in Seat
//    @JoinColumn(name = "ticketId",referencedColumnName = "ticketId")
//    private List<Seat> seat;


//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ticketId", referencedColumnName = "ticketId")
//    private List<Seat> seat;

//  @OneToMany(cascade = CascadeType.ALL)
//  @JoinColumn(name = "ticketId", nullable = false)
//  private List<PaymentInfo> paymentInfo;
}
