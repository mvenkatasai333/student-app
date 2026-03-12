package com.student.student_app.service;

import com.student.student_app.dto.StudentRequestDTO;
import com.student.student_app.dto.StudentResponseDTO;
import com.student.student_app.entity.Student;
import com.student.student_app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // SAVE student
    public StudentResponseDTO saveStudent(
            StudentRequestDTO requestDTO) {
        Student student = new Student();
        student.setName(requestDTO.getName());
        student.setEmail(requestDTO.getEmail());
        student.setCourse(requestDTO.getCourse());
        Student saved = studentRepository.save(student);
        return convertToDTO(saved);
    }

    // GET all students
    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // GET one student
    public StudentResponseDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Student not found! ID: " + id));
        return convertToDTO(student);
    }

    // UPDATE student
    public StudentResponseDTO updateStudent(
            Long id,
            StudentRequestDTO requestDTO) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Student not found! ID: " + id));
        existing.setName(requestDTO.getName());
        existing.setEmail(requestDTO.getEmail());
        existing.setCourse(requestDTO.getCourse());
        return convertToDTO(studentRepository.save(existing));
    }

    // DELETE student
    public String deleteStudent(Long id) {
        studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Student not found! ID: " + id));
        studentRepository.deleteById(id);
        return "Student deleted successfully!";
    }

    // HELPER - converts Student to ResponseDTO
    private StudentResponseDTO convertToDTO(Student student) {
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setCourse(student.getCourse());
        return dto;
    }
}
