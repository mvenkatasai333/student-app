package com.student.student_app.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="students")
@Data
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private String email;
    private String course;
}

















