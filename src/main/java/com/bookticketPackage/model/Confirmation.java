package com.bookticketPackage.model;
import java.util.Calendar;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Confirmation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "confirmation_id")
    private long confirmationId;

    @Column(name = "confirmation_date")
    private Date confimationDate;

    @Column(name = "confirmation_code")
    private String confirmationCode;// = String.valueOf(confirmationId + this.customer.getCustomerId());


    @OneToOne(optional = false)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "paymentInfoId")
//    private PaymentInfo paymentInfo;

}
