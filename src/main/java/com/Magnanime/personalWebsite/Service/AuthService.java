package com.Magnanime.personalWebsite.Service;

import com.Magnanime.personalWebsite.DTO.RegisterRequest;
import com.Magnanime.personalWebsite.Model.User;
import com.Magnanime.personalWebsite.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUserName(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());

        userRepository.save(user);
    }
}
