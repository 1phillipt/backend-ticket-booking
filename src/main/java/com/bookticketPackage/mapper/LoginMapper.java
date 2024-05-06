package com.bookticketPackage.mapper;

import com.bookticketPackage.dto.LoginDto;
import com.bookticketPackage.model.Login;

public class LoginMapper {
    public static Login loginDtoToLogin(LoginDto loginDto){
        return Login.builder()
                .customerId(loginDto.getCustomerId())
                    .email(loginDto.getEmail())
                            .password(loginDto.getPassword()).build();
    }
    public static LoginDto loginToLoginDto(Login login){
        return LoginDto.builder()
                .customerId(login.getCustomerId())
                .email(login.getEmail())
                .password(login.getPassword()).build();
    }
}
