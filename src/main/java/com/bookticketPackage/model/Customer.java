package com.bookticketPackage.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotEmpty @NotNull
    private String fname;
    @NotEmpty @NotNull
    private String lname;
    @NotEmpty @Email
    private String email;
    @NotEmpty@Size(min = 10) @NotNull
    private String phoneNumber;
    @NotEmpty @Size(min = 6) @NotNull
    private String password;






//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
//    private List<PaymentInfo> paymentInfo;

//    @OneToMany(mappedBy ="customer",cascade = CascadeType.ALL)
//    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
//    private List<PaymentInfo> paymentInfo;
}
