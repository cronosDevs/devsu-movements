package com.devsu.movements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MovementsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovementsApplication.class, args);
    }

}
