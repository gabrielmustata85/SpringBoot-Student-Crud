package com.example.demo.controllers;

import com.example.demo.model.Student;
import com.example.demo.services.StudentService;
import com.example.demo.services.StudentsServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> student = studentService.listAll();
        return new ResponseEntity<>(student, OK);
    }
}
