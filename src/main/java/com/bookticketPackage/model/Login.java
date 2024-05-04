package com.bookticketPackage.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    @Id
    private String email;
    private String password;
}
