package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prof {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private String course;
    private int age;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prof_students", joinColumns ={@JoinColumn(name = "prof_id",referencedColumnName="id" )}, inverseJoinColumns ={@JoinColumn(name = "student_id", referencedColumnName="id")})
    private Set<Student> students = new HashSet<>();


}
