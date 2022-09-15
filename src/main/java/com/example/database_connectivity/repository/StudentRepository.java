package com.example.database_connectivity.repository;

import com.example.database_connectivity.model.StudentModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel,Long> {

 //   @Query("SELECT StudentModel  so FROM  student_model so WHERE s.email=?1 ");
   Optional<StudentModel> findStudentModelByEmail(String email);



}
