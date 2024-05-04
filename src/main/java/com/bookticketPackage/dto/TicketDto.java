package com.bookticketPackage.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {
    private long ticketID;
    private long eventID;
    private long customerID;
}

