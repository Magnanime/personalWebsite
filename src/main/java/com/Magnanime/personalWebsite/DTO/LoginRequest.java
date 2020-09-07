package com.Magnanime.personalWebsite.DTO;

import lombok.Getter;
import lombok.Setter;

//Data transfer object for login

@Getter
@Setter
public class LoginRequest {
    private String username;
    private String password;
}