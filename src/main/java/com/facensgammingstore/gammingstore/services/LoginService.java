package com.facensgammingstore.gammingstore.services;

import com.facensgammingstore.gammingstore.entities.User;
import com.facensgammingstore.gammingstore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository repository;

    public User LoginAuthentication(String email, String password) {
        Optional<User> obj = repository.findByEmail(email);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        boolean isPassword = passwordEncoder.matches(password, obj.get().getPassword());

        if(!isPassword) {
            return null;
        }

        return obj.get();
    }

}
