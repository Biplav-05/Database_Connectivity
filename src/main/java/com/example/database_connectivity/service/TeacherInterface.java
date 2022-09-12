package com.example.database_connectivity.service;

import com.example.database_connectivity.model.TeacherModel;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherInterface {

    public void insertTeacherData(TeacherModel teacherModel);

    List<TeacherModel> getAllTeachers();
}
