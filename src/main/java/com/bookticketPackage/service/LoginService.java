package com.bookticketPackage.service;

import com.bookticketPackage.dto.LoginDto;
import com.bookticketPackage.mapper.LoginMapper;
import com.bookticketPackage.model.Login;
import com.bookticketPackage.repository.LoginRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private LoginRepository loginRepository;
    public LoginService( LoginRepository loginRepository){
        this.loginRepository = loginRepository;
    }

    public String verifyLogin(LoginDto loginDto){
//
//        loginRepository.insertCustomerEmailPasswordToLogin();

        Optional<Login> optionalLogin = loginRepository.findById(loginDto.getEmail());
        System.out.println(optionalLogin);
        if( optionalLogin.isPresent() && optionalLogin.get().getPassword().equals(loginDto.getPassword())) {

            return "login successful";
        }else {
            if(optionalLogin.isPresent() && !optionalLogin.get().getPassword().equals(loginDto.getPassword())){
                return "password did not match";
            };
        }
        return "email not found";
    }
}
