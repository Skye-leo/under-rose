package com.heim.underrose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UnderRoseApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnderRoseApplication.class, args);
    }

}
