package com.example.database_connectivity.configuration;

import com.example.database_connectivity.model.TeacherModel;
import com.example.database_connectivity.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TeacherConfig {
    @Bean
    CommandLineRunner commandLineRunner1(TeacherRepository teacherRepository){
        return args -> {
            TeacherModel ram =new TeacherModel("Ram","IT","ram@gmail.com");
           TeacherModel shyam= new TeacherModel("Shyam","HR","@shyam@gmail.com");
           teacherRepository.saveAll(List.of(ram,shyam));
        };
    }
}
