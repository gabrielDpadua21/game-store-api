package com.facensgammingstore.gammingstore.config;

import com.facensgammingstore.gammingstore.entities.User;
import com.facensgammingstore.gammingstore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User("Deam Winchester", "ddog@gmail.com", "5550001", "123456");
        User u2 = new User("Sam Winchester", "sammy@gmail.com", "5550002", "123456");
        User u3 = new User("Castiel", "cas@gmail.com", "0000001", "god");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

    }
}
