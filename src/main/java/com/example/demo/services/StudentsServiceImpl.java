package com.example.demo.services;

import com.example.demo.model.Student;
import com.example.demo.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentsServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final BCryptPasswordEncoder passwordEncoder;

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

    @Override
    public Student saveStudentParam(String firstName, String lastName, String username, String email, String password) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setUsername(username);
        student.setEmail(email);
        student.setPassword(passwordEncoder.encode(password));
        studentRepository.save(student);
        return student;
    }

    @Override
    public void saveStudentNewBody(Student student) {
        student.setFirstName(student.getFirstName());
        student.setLastName(student.getLastName());
        student.setEmail(student.getEmail());
        student.setUsername(student.getUsername());
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentRepository.save(student);
    }
}
