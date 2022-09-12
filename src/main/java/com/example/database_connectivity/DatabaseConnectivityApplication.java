package com.example.database_connectivity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan("com")
public class DatabaseConnectivityApplication {


    public static void main(String[] args) {
        SpringApplication.run(DatabaseConnectivityApplication.class, args);
    }


}
