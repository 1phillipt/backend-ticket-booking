package com.bookticketPackage.mapper;

import com.bookticketPackage.dto.CustomerDto;
import com.bookticketPackage.model.Customer;

public class CustomerMapper {

    public static CustomerDto customerToCustomerDto(Customer customer){
        return CustomerDto.builder()
                .customerId(customer.getCustomerId())
                .fname(customer.getFname())
                .lname(customer.getLname())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .password(customer.getPassword())
                .build();
    }

    public static Customer customerDtoToCustomer(CustomerDto customerDto){
        return Customer.builder()
                .customerId(customerDto.getCustomerId())
                .fname(customerDto.getFname())
                .lname(customerDto.getLname())
                .email(customerDto.getEmail())
                .phoneNumber(customerDto.getPhoneNumber())
                .password(customerDto.getPassword())
                .build();
    }
}
