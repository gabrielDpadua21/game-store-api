package com.facensgammingstore.gammingstore.config;

import com.facensgammingstore.gammingstore.entities.Category;
import com.facensgammingstore.gammingstore.entities.Order;
import com.facensgammingstore.gammingstore.entities.Product;
import com.facensgammingstore.gammingstore.entities.User;
import com.facensgammingstore.gammingstore.entities.enums.OrderStatus;
import com.facensgammingstore.gammingstore.repositories.CategoryRepository;
import com.facensgammingstore.gammingstore.repositories.OrderRepository;
import com.facensgammingstore.gammingstore.repositories.ProductRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Deam Winchester", "ddog@gmail.com", "5550001", "123456");
        User u2 = new User(null, "Sam Winchester", "sammy@gmail.com", "5550002", "123456");
        User u3 = new User(null,  "Castiel", "cas@gmail.com", "0000001", "god");
        User u4 = new User(null, "Crowley", "kingdevil@gmail.com", "000666", "hell");

        Order o1 = new Order(null, Instant.parse("2020-09-20T19:53:07Z"), OrderStatus.DELIVERED, u1);
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

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        categoryRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
    }
}
