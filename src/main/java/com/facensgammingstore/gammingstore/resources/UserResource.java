package com.facensgammingstore.gammingstore.resources;

import com.facensgammingstore.gammingstore.DTO.UserDTO;
import com.facensgammingstore.gammingstore.entities.Login;
import com.facensgammingstore.gammingstore.entities.User;
import com.facensgammingstore.gammingstore.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody User obj) {
        obj = services.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        UserDTO objDto = new UserDTO(obj);
        return ResponseEntity.created(uri).body(objDto);
    }

}
