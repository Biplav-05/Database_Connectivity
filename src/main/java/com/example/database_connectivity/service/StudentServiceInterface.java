package com.example.database_connectivity.service;

import com.example.database_connectivity.model.StudentModel;
//import model.StudentModel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface StudentServiceInterface {
    public List<StudentModel> giveStudentData();




    void addNewStudent(StudentModel studentModel);

    void removeStudent(Long studentId);

    void updateStudent(Long studentId, String name, String email);
}
