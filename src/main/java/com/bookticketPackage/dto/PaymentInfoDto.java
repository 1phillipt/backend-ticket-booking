package com.bookticketPackage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfoDto {
    private  long paymentInfoId;
    private  String cardNumber;
    private  String paymentType;
    private long customerId;
}
