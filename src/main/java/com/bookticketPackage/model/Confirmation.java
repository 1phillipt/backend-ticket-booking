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

    private Date confirmationDateAndTime;

    private long ticketId;

    private long customerId;


}
