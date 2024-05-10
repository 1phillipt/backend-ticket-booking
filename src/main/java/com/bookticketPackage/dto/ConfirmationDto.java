package com.bookticketPackage.dto;

import com.bookticketPackage.model.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmationDto {

    private long confirmationId;
    private LocalDate confirmationDate;
    private long   ticketId;
    private long customerId;
}
