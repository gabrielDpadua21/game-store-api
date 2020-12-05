package com.facensgammingstore.gammingstore.resources;

import com.facensgammingstore.gammingstore.entities.Login;
import com.facensgammingstore.gammingstore.entities.User;
import com.facensgammingstore.gammingstore.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class LoginResource {

    @Autowired
    private LoginService services;

    public ResponseEntity<User> login(@RequestBody Login obj) {
        User user = services.LoginAuthentication(obj.getEmail(), obj.getPassword());

        return ResponseEntity.ok().body(user);
    }

}
