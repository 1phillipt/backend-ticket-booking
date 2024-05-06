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
    private String email;
    private String password;
}
