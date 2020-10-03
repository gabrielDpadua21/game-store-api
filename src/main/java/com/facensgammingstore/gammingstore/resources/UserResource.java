package com.facensgammingstore.gammingstore.resources;

import com.facensgammingstore.gammingstore.entities.User;
import com.facensgammingstore.gammingstore.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserServices services;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = services.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = services.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value = "/mail/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        User user = services.findByEmail(email);
        return ResponseEntity.ok().body(user);
    }

}
