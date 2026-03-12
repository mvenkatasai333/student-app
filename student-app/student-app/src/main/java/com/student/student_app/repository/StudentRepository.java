package com.student.student_app.repository;

import com.student.student_app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository
     extends JpaRepository<Student, Long> {

}

