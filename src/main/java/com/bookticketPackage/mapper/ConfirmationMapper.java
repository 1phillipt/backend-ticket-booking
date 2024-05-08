package com.bookticketPackage.mapper;

import com.bookticketPackage.dto.ConfirmationDto;
import com.bookticketPackage.model.Confirmation;
import com.bookticketPackage.model.Customer;
import com.bookticketPackage.model.PaymentInfo;
import com.bookticketPackage.model.Ticket;

import java.util.Date;

public class ConfirmationMapper {
//    private long confirmationId;
//    private Date confirmationDate;
//    private long   ticketId;
//    private long customerId;
    public static ConfirmationDto confirmationToConfirmationDto(Confirmation confirmation){
        return ConfirmationDto.builder()
                .confirmationId(confirmation.getConfirmationId())
                .confirmationDate(confirmation.getConfimationDate())
                .customerId(confirmation.getCustomerId())
                .ticketId(confirmation.getTicketId())
                .build();
    }
    public static Confirmation confirmationDtoToConfirmation(ConfirmationDto confirmationDto){
        return   Confirmation.builder()
                .confirmationId(confirmationDto.getConfirmationId())
                .confimationDate(confirmationDto.getConfirmationDate())
                .customerId(confirmationDto.getCustomerId())
                .ticketId(confirmationDto.getTicketId())
                .build();
    }
}
