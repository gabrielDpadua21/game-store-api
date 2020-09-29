package com.facensgammingstore.gammingstore.resources;

import com.facensgammingstore.gammingstore.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User test = new User(1, "Dean", "ddog@winchester.com", "5550001", "john");

        return ResponseEntity.ok().body(test);
    }

}
