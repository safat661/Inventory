package com.example.inventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            Product product= new Product("Desert", "Magnum", (int) 6.99, 22);

            productRepository.saveAll(List.of(product));
        };
    }
}
