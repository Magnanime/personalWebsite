package com.Magnanime.personalWebsite.DTO;

import lombok.Getter;
import lombok.Setter;

//Data transfer object for registering a new user

@Setter
@Getter
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
}
