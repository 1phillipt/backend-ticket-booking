package com.bookticketPackage.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatDto {
    private long seatID;
    private double price;
    private String seatNumber;
    private long eventId;
    private int available;
}
