package com.bookticketPackage.model;


import jakarta.persistence.*;
import lombok.*;


@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    @Id
    private long customerId;
    @OneToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    private String email;
    private String password;
}
