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
    private long ticketId;
    private long eventId;
    private long customerId;
    private long seatId;
}

