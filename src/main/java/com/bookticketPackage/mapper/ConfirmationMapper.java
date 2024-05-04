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
//    private String confirmationCode;
//    private long   ticketId;
//    private long customerId;
    public static ConfirmationDto confirmationToConfirmationDto(Confirmation confirmation){
        return ConfirmationDto.builder()
                .confirmationId(confirmation.getConfirmationId())
                .confirmationDate(confirmation.getConfimationDate())
                .confirmationCode(confirmation.getConfirmationCode())
                .customerId(confirmation.getCustomer().getCustomerId())
                .ticketId(confirmation.getTicket().getTicketId())
                .build();
    }
    public static Confirmation confirmationDtoToConfirmation(ConfirmationDto confirmationDto){
        return   Confirmation.builder()
                .confirmationId(confirmationDto.getConfirmationId())
                .confimationDate(confirmationDto.getConfirmationDate())
                .confirmationCode(confirmationDto.getConfirmationCode())
                .customer(Customer.builder().customerId(confirmationDto.getCustomerId()).build())
                .ticket(Ticket.builder().ticketId(confirmationDto.getTicketId()).build())
                .build();
    }
}
