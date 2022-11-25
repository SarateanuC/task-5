package com.example.task5.controller;

import com.example.task5.model.ProfessorDbo;
import com.example.task5.model.StudentDbo;
import com.example.task5.service.ProfessorService;
import com.example.task5.service.impl.ProfessorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/professor")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;

    @GetMapping("/all")
    public List<ProfessorDbo> selectAllStudents(){
        return professorService.selectAll();
    }

    @GetMapping("/by-id")
    public ProfessorDbo selectById(@RequestParam("id")UUID id){
        return professorService.selectById(id);
    }
}
