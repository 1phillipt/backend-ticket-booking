package com.bookticketPackage.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenueDto {

    private long vanueId;
    private String name;
    private String address;
    private int capacity;

}
