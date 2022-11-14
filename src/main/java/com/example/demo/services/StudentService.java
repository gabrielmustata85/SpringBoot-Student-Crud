package com.example.demo.services;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> listAll();

    Student getById(Long id);

    Student update(Student student);

    Student saveStudent(Student student);

    void delete(Long id);

    Student saveStudentParam(String firstName, String lastName, String username, String email, String password);

    void saveStudentNewBody(Student student);
}
