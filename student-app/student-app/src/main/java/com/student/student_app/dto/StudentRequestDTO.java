package com.student.student_app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentRequestDTO {

    @NotBlank(message = "Name is required!")
    private String name;

    @Email(message = "Please enter valid email!")
    @NotBlank(message = "Email is required!")
    private String email;

    @NotBlank(message = "Course is required!")
    private String course;
}


