package com.example.database_connectivity.repository;

import com.example.database_connectivity.model.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository

public interface TeacherRepository extends JpaRepository<TeacherModel,Long> {
}
