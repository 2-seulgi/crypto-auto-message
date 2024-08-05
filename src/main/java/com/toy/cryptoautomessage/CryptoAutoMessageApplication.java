package com.toy.cryptoautomessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.module.Configuration;

@SpringBootApplication
public class CryptoAutoMessageApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CryptoAutoMessageApplication.class, args);
        SpringApplication.exit(run);
    }
}
