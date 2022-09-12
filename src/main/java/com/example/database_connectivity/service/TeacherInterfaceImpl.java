package com.example.database_connectivity.service;

import com.example.database_connectivity.model.TeacherModel;
import com.example.database_connectivity.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherInterfaceImpl implements TeacherInterface{

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherInterfaceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void insertTeacherData(TeacherModel teacherModel)
    {
        teacherRepository.save(teacherModel);
    }

    @Override
    public List<TeacherModel> getAllTeachers() {
      return teacherRepository.findAll();
    }
}
