package com.vallegrande.sadeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class SadebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SadebApplication.class, args);
    }


}
