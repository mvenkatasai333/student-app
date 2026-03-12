package com.student.student_app.controller;

import com.student.student_app.dto.StudentRequestDTO;
import com.student.student_app.dto.StudentResponseDTO;
import com.student.student_app.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // ADD student
    // URL: POST http://localhost:8080/students
    @PostMapping
    public ResponseEntity<StudentResponseDTO> addStudent( @Valid
            @RequestBody StudentRequestDTO request) {
        return ResponseEntity
                .status(201)
                .body(studentService.saveStudent(request));
    }

    // GET all students
    // URL: GET http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAll() {
        return ResponseEntity
                .ok(studentService.getAllStudents());
    }

    // GET one student
    // URL: GET http://localhost:8080/students/1
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getOne(
            @PathVariable Long id) {
        return ResponseEntity
                .ok(studentService.getStudentById(id));
    }

    // UPDATE student
    // URL: PUT http://localhost:8080/students/1
    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> update(
            @PathVariable Long id,
            @RequestBody StudentRequestDTO request) {
        return ResponseEntity
                .ok(studentService.updateStudent(id, request));
    }

    // DELETE student
    // URL: DELETE http://localhost:8080/students/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {
        return ResponseEntity
                .ok(studentService.deleteStudent(id));
    }
}



