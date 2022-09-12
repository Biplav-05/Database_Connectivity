package com.example.database_connectivity.configuration;

import com.example.database_connectivity.model.StudentModel;
import com.example.database_connectivity.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (StudentRepository studentRepository){
        return args -> {
          StudentModel rahul =  new StudentModel(
                    "Rahul Mijar",
                    "Hetauda",
                    "b@gmail.com");
            StudentModel biplav =  new StudentModel(
                    "Biplav Ghimire",
                    "Hetauda",
                    "a@gmail.com");
            studentRepository.saveAll(List.of(rahul,biplav));
        };

    }
}
