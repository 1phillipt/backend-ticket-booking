package com.bookticketPackage.mapper;

import com.bookticketPackage.dto.LoginDto;
import com.bookticketPackage.model.Login;

public class LoginMapper {
    public static Login loginDtoToLogin(LoginDto loginDto){
        return Login.builder().email(loginDto.getEmail()).password(loginDto.getPassword()).build();
    }
    public static LoginDto loginToLoginDto(Login login){
        return LoginDto.builder().email(login.getEmail()).password(login.getPassword()).build();
    }
}
