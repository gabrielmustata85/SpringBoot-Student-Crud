package com.example.demo.services;

import com.example.demo.model.Student;
import com.example.demo.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentsServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    @Override
    public List<Student> listAll() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    @Override
    public Student getById(Long id) {
        return null;
    }

    @Override
    public Student update(Long id, Student student) {
        return null;
    }

    @Override
    public Student saveStudent(Student student) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
