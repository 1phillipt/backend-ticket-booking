package com.bookticketPackage.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;
    @NotNull
    private String fname;
    @NotNull
    private String lname;
    @NotNull
    private String email;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String password;






//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
//    private List<PaymentInfo> paymentInfo;

//    @OneToMany(mappedBy ="customer",cascade = CascadeType.ALL)
//    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
//    private List<PaymentInfo> paymentInfo;
}
