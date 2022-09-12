package com.example.database_connectivity.controller;

import com.example.database_connectivity.model.StudentModel;
import com.example.database_connectivity.service.StudentServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/")
public class StudentController {

    private StudentServiceInterface studentServiceInterface;

    @Autowired
    public StudentController(StudentServiceInterface studentServiceInterface)
    {
        this.studentServiceInterface=studentServiceInterface;
    }

    @GetMapping("getData")
    public List<StudentModel> getData()
    {
        //return new StudentModel(10L,"Biplav","Hetauda","biplav413@gmail.com");
        return studentServiceInterface.giveStudentData();

    }


    @PostMapping("/postData")
    public void registerNewStudent(@RequestBody StudentModel studentModel)
    {
        studentServiceInterface.addNewStudent(studentModel);
    }

    @DeleteMapping("/delete/{studentId}")
    public void deleteStudent(@PathVariable Long studentId)
    {
        studentServiceInterface.removeStudent(studentId);
    }

    @PutMapping ("update/{studentId}")
    public void updateStudent(@PathVariable Long studentId,@RequestParam (required = false) String name,@RequestParam(required = false) String email)
    {
        studentServiceInterface.updateStudent(studentId,name,email);
    }
}
