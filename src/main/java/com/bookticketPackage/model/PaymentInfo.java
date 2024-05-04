package com.bookticketPackage.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaymentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long paymentInfoId;
    private  String cardNumber;
    private  String paymentType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;


//    @ManyToOne(optional = false)
//    @JoinColumn(name = "customerId", nullable = false)
//    private Customer customer;

}
