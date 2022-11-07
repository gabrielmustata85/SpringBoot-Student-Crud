package com.example.demo.controllers;


import com.example.demo.model.Prof;
import com.example.demo.model.Student;
import com.example.demo.services.ProfService;
import com.example.demo.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/prof")
public class ProfController {

    private final ProfService profService;

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<Prof>> getAllProfs() {
        List<Prof> prof = profService.listAll();
        return new ResponseEntity<>(prof, OK);
    }

}
