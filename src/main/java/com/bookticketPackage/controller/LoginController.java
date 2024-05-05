package com.bookticketPackage.controller;

import com.bookticketPackage.dto.LoginDto;
import com.bookticketPackage.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/login")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping("/verify")
    public ResponseEntity<Long> verifyLogin(@RequestBody LoginDto loginDto){
        if (loginService.verifyLogin(loginDto) != null) {
            return ResponseEntity.ok(loginService.verifyLogin(loginDto));
        } else {
            return ResponseEntity.notFound().build();
        }
        //System.out.println(ResponseEntity.ok().body(loginService.verifyLogin(loginDto)));
    }
}
