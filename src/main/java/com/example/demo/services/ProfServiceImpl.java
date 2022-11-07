package com.example.demo.services;

import com.example.demo.model.Prof;
import com.example.demo.model.Student;
import com.example.demo.repositories.ProfRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProfServiceImpl implements ProfService {

    private final ProfRepository profRepository;

    @Override
    public List<Prof> listAll() {
        List<Prof> prof = new ArrayList<>();
        profRepository.findAll().forEach(prof::add);
        return prof;
    }
}
