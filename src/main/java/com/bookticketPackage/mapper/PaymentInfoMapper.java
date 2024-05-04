package com.bookticketPackage.mapper;

import com.bookticketPackage.dto.PaymentInfoDto;
import com.bookticketPackage.model.Customer;
import com.bookticketPackage.model.PaymentInfo;

public class PaymentInfoMapper {

    public static PaymentInfoDto paymentInfoToPaymentInfoDto(PaymentInfo paymentInfo){
        return PaymentInfoDto.builder()
                .paymentInfoId(paymentInfo.getPaymentInfoId())
                .paymentType(paymentInfo.getPaymentType())
                .cardNumber(paymentInfo.getCardNumber())
                .customerId(paymentInfo.getCustomer().getCustomerId())
                .build();
    }
    public static PaymentInfo paymentInfoDtoToPaymentInfo(PaymentInfoDto paymentInfoDto){
        return PaymentInfo.builder()
                .customer(Customer.builder().customerId(paymentInfoDto.getCustomerId()).build())
                .paymentType(paymentInfoDto.getPaymentType())
                .paymentInfoId(paymentInfoDto.getPaymentInfoId())
                .cardNumber(paymentInfoDto.getCardNumber())
                .build();
    }
}
