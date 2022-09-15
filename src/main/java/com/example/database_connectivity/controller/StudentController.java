package com.example.database_connectivity.controller;

import com.example.database_connectivity.exception.UpdateFaliureException;
import com.example.database_connectivity.model.ApiResponse;
import com.example.database_connectivity.model.StudentModel;
import com.example.database_connectivity.service.StudentServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class StudentController extends ApiResponse {

    private StudentServiceInterface studentServiceInterface;


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


//    @PostMapping("/postData")
//    public void registerNewStudent(@RequestBody StudentModel studentModel)
//    {
//        studentServiceInterface.addNewStudent(studentModel);
//    }

    @DeleteMapping("/delete/{studentId}")
    public ApiResponse deleteStudent(@PathVariable Long studentId)
    {

         return studentServiceInterface.removeStudent(studentId);



       // return studentServiceInterface.removeStudent(studentId);
    }

    @PutMapping ("addAndUpdate")
    public ApiResponse updateStudent(@RequestBody StudentModel studentModel) throws UpdateFaliureException{
        return  studentServiceInterface.updateStudent(studentModel);
    }
}
