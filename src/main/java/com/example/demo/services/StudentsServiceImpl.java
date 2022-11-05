package com.example.demo.services;

import com.example.demo.model.Student;
import com.example.demo.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentsServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> listAll() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student update(Long id, Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student saveStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
