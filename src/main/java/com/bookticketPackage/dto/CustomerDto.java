package com.bookticketPackage.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class CustomerDto {
    private long customerId;
    private String fname;
    private String lname;
    private String email;
    private String phoneNumber;
    private String password;

}
