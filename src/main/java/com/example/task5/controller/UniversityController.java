package com.example.task5.controller;

import com.example.task5.model.ProfessorDbo;
import com.example.task5.model.UniversityDbo;
import com.example.task5.service.UniversityService;
import com.example.task5.service.impl.UniversityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/university")
@RequiredArgsConstructor
public class UniversityController {
    private final UniversityService universityService;

    @GetMapping("/all")
    public List<UniversityDbo> selectAllStudents(){
        return universityService.selectAll();
    }

    @GetMapping("/by-id")
    public UniversityDbo selectById(@RequestParam("id") UUID id){
        return universityService.selectById(id);
    }

}
