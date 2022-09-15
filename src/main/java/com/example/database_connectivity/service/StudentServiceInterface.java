package com.example.database_connectivity.service;

import com.example.database_connectivity.exception.UpdateFaliureException;
import com.example.database_connectivity.model.ApiResponse;
import com.example.database_connectivity.model.StudentModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentServiceInterface {
    public List<StudentModel> giveStudentData();




    void addNewStudent(StudentModel studentModel);

     ApiResponse removeStudent(Long studentId);

    ApiResponse updateStudent(StudentModel studentModel) throws UpdateFaliureException;

//    List<StudentModel> getSelectedUser(String grade);
  Optional<StudentModel> findById(Long id);
}
