package com.example.database_connectivity.service;

import com.example.database_connectivity.model.StudentModel;
//import model.StudentModel;
import com.example.database_connectivity.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Component
public class ServiceImpl implements StudentServiceInterface {

    private StudentRepository studentRepository;

    @Autowired
    public ServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    List<StudentModel> studentModelList = new ArrayList<StudentModel>();

    @Override
    public List<StudentModel> giveStudentData() {
        return studentRepository.findAll();
    }

    @Override
    public void addNewStudent(StudentModel studentModel) {
      Optional<StudentModel> optionalStudentModel= studentRepository.findStudentModelByEmail(studentModel.getEmail());
       if(optionalStudentModel.isPresent())
       {
           throw new IllegalStateException("Email already exists");
       }
       studentRepository.save(studentModel);
        System.out.println(studentModel);
    }

    @Override
    public void removeStudent(Long studentId) {
        boolean exists=studentRepository.existsById(studentId);
        if(!exists)
        {
            throw new IllegalStateException("student id " +studentId+" doesnot exists");
        }
        studentRepository.deleteById(studentId);
        System.out.println(studentId +" is deleted");
    }

    @Override
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {

        StudentModel studentModel = studentRepository.findById(studentId).
                orElseThrow(()->  new IllegalStateException("Student Id "+studentId+" doesnot exists"));
        if(name!=null && name.length()>0 &&
                !Objects.equals(studentModel.getName(),name))
        {
            studentModel.setName(name);
        }
        if(email!=null && email.length()>0 &&
        !Objects.equals(studentModel.getEmail(),email))
        {
            Optional<StudentModel> emailOptional = studentRepository.findStudentModelByEmail(email);
            if(!emailOptional.isPresent())
            {
                throw new IllegalStateException("Email "+ email +" is not present in database");
            }
            studentModel.setEmail(email);
        }

    }

    @Override
    public List<StudentModel> getSelectedUser(String grade) {
        return studentRepository.findByClassModelGrade(grade);
    }
}
