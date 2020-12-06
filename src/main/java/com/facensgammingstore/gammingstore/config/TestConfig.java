package com.facensgammingstore.gammingstore.config;

import com.facensgammingstore.gammingstore.entities.*;
import com.facensgammingstore.gammingstore.entities.enums.OrderStatus;
import com.facensgammingstore.gammingstore.repositories.*;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Deam Winchester", "ddog@gmail.com", "5550001", "123456");
        User u2 = new User(null, "Sam Winchester", "sammy@gmail.com", "5550002", "123456");
        User u3 = new User(null,  "Castiel", "cas@gmail.com", "0000001", "god");
        User u4 = new User(null, "Crowley", "kingdevil@gmail.com", "000666", "hell");

        Order o1 = new Order(null, Instant.parse("2020-09-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2020-08-20T14:53:07Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2020-07-20T21:53:07Z"), OrderStatus.SHIPPED, u3);

        Category c1 = new Category(null, "Ação");
        Category c2 = new Category(null, "Aventura");
        Category c3 = new Category(null, "Terror");
        Category c4 = new Category(null, "RPG");

        Product p1 = new Product(null, "The witcher III - Wind hunt", "Game of the year", 70.85, "");
        Product p2 = new Product(null, "Tomb Raider", "First Lara Adventure", 30.25, "");
        Product p3 = new Product(null, "Rise of the Tomb Raider", "Best Lara Adventure", 102.85, "");
        Product p4 = new Product(null, "Shadow of the Tomb Raider", "Last Lara Adventure", 70.85, "");

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p2, 2, p2.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p4, 2, p4.getPrice());

        p1.getCategories().add(c1);
        p2.getCategories().add(c2);
        p3.getCategories().add(c2);
        p4.getCategories().add(c2);

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        categoryRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment pay1 = new Payment(null, Instant.parse("2020-09-20T21:53:07Z"), o1);
        o1.setPayment(pay1);

        orderRepository.save(o1);
    }
}
