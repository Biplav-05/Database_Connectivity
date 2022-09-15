package com.example.database_connectivity.service;

import com.example.database_connectivity.exception.UpdateFaliureException;
import com.example.database_connectivity.model.ApiResponse;
import com.example.database_connectivity.model.StudentModel;
import com.example.database_connectivity.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ServiceImpl extends ApiResponse implements StudentServiceInterface {

    private StudentRepository studentRepository;


    public ServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentModel> giveStudentData() {
        return studentRepository.findAll();
    }

    @Override
    public void addNewStudent(StudentModel studentModel) {
        Optional<StudentModel> optionalStudentModel = studentRepository.findStudentModelByEmail(studentModel.getEmail());
        if (optionalStudentModel.isPresent()) {
            throw new IllegalStateException("Email already exists");
        }
        studentRepository.save(studentModel);
        System.out.println(studentModel);
    }

    @Override
    public ApiResponse removeStudent(Long studentId) {
        if (studentId != null) {
            if (studentRepository.findById(studentId).isPresent()) {
                studentRepository.deleteById(studentId);
                return success("Student id: " + studentId + "is deleted successfully", null);
            }
        }
        return error("Sorry given id " + studentId + " is not present in our database", null);

    }

    @Override
    public ApiResponse updateStudent(StudentModel studentModel) throws UpdateFaliureException {
        if (studentModel.getId() == null) {
            return success("new data inserted", studentRepository.save(studentModel));
        } else if (studentRepository.findById(studentModel.getId()).isPresent()) {

            return success("data updated ", studentRepository.save(studentModel));
        } else {
            throw new UpdateFaliureException("Student ID :" + studentModel.getId() + " didn't match in our database..");
        }
    }

    @Override
    public Optional<StudentModel> findById(Long id) {
        Optional<StudentModel> optionalStudentModel = studentRepository.findById(id);
        return optionalStudentModel;
    }
}
