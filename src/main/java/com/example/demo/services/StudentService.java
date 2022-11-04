package com.example.demo.services;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    List<Student> listAll();

    Student getById(Long id);

    Student update(Long id, Student student);

    Student saveStudent(Student student);

    void delete(Long id);
}
