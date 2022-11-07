package com.example.demo.controllers;

import com.example.demo.model.Student;
import com.example.demo.services.StudentService;
import com.example.demo.services.StudentsServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> student = studentService.listAll();
        return new ResponseEntity<>(student, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id ){
        Student student = studentService.getById(id);
        return ResponseEntity.ok().body(student);
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return new ResponseEntity<>(student, CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Student> editStudent(@RequestBody Student student, @PathVariable ("id") Long id) {
        studentService.update(id, student);
        return new ResponseEntity<>(student, CREATED);
    }

    @DeleteMapping("delete/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.delete(id);
    }
}
