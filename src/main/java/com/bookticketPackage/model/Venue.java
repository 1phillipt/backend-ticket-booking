package com.bookticketPackage.model;

import jakarta.persistence.*;
import lombok.*;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "venue")
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long venueId;
    private String name;
    private String address;
    private int capacity;

}
