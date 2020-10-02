package com.Magnanime.personalWebsite.WebControllers;

import com.Magnanime.personalWebsite.DTO.LoginRequest;
import com.Magnanime.personalWebsite.DTO.RegisterRequest;
import com.Magnanime.personalWebsite.Service.AuthService;
import com.Magnanime.personalWebsite.DTO.AuthenticationResponse;
import com.Magnanime.personalWebsite.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        try{
            authService.signup(registerRequest);
            emailService.sendSimpleMessage(registerRequest.getEmail(),
                         System.getProperty("custom.registrationResponseTitle"),
                         System.getProperty("custom.registrationResponseBody"),
                         System.getProperty("custom.registrationFrom"));
        } catch (ConstraintViolationException e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
