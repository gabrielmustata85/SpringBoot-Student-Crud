package com.example.demo.controllers;

import com.example.demo.model.Student;
import com.example.demo.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/student")
public class StudentController {

    private final String SUCCESS_MESSAGE = "Student created successfully";
    private final StudentService studentService;

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> student = studentService.listAll();
        return new ResponseEntity<>(student, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getById(id);
        return ResponseEntity.ok().body(student);
    }

    @PostMapping("/addStudentWithParam")
    public ResponseEntity<String> addStudentParam(@RequestParam("firstName") String firstName,
                                                  @RequestParam("lastName") String lastName,
                                                  @RequestParam("username") String username,
                                                  @RequestParam("email") String email,
                                                  @RequestParam("password") String password) {
        studentService.saveStudentParam(firstName, lastName, username, email, password);
        return new ResponseEntity<>(SUCCESS_MESSAGE, CREATED);
    }

    @PostMapping("/addStudentWithBody")
    public ResponseEntity<String> addStudentBody(@RequestBody Student student) {
        studentService.saveStudentNewBody(student);
        return new ResponseEntity<>(SUCCESS_MESSAGE, CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Student> editStudent(@RequestBody Student student, @PathVariable("id") Long id) {
        student.setId(id);
        studentService.update(student);
        return new ResponseEntity<>(student, OK);
    }

    @DeleteMapping("delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
    }
}
