package com.example.database_connectivity.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.ConstructorParameters;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class TeacherModel {
    @Id
    @SequenceGenerator(name = "teacher_sequence",sequenceName="teacher_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "teacher_sequence")
    private  Long id;
    private String name;
    private String department;
    private String email;

    public TeacherModel(String name, String department, String email) {
        this.name = name;
        this.department = department;
        this.email = email;
    }



    @Override
    public String toString() {
        return "TeacherModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
