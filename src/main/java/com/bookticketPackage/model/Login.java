package com.bookticketPackage.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    @Id
    private long customerId;
    @Email @NotNull
    private String email;
    @Size(min = 6)
    private String password;
}
