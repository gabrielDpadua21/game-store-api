package com.facensgammingstore.gammingstore.config;

import com.facensgammingstore.gammingstore.entities.Order;
import com.facensgammingstore.gammingstore.entities.User;
import com.facensgammingstore.gammingstore.entities.enums.OrderStatus;
import com.facensgammingstore.gammingstore.repositories.OrderRepository;
import com.facensgammingstore.gammingstore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Deam Winchester", "ddog@gmail.com", "5550001", "123456");
        User u2 = new User(null, "Sam Winchester", "sammy@gmail.com", "5550002", "123456");
        User u3 = new User(null,  "Castiel", "cas@gmail.com", "0000001", "god");
        User u4 = new User(null, "Crowley", "kingdevil@gmail.com", "000666", "hell");

        Order o1 = new Order(null, Instant.parse("2020-09-20T19:53:07Z"), OrderStatus.DELIVERED, u1);
        Order o2 = new Order(null, Instant.parse("2020-08-20T14:53:07Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2020-07-20T21:53:07Z"), OrderStatus.SHIPPED, u3);

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
