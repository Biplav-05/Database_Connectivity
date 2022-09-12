package com.example.database_connectivity.controller;

import com.example.database_connectivity.model.TeacherModel;
import com.example.database_connectivity.service.TeacherInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private TeacherInterface teacherInterface;

    @Autowired
    public TeacherController(TeacherInterface teacherInterface) {
        this.teacherInterface = teacherInterface;
    }

    @PostMapping("/insertData")
    public void insertData(@RequestBody TeacherModel teacherModel)
    {
        teacherInterface.insertTeacherData(teacherModel);

    }

    @GetMapping("/getTeacherData")
    public List<TeacherModel> getData()
    {
        return teacherInterface.getAllTeachers();
    }
}
