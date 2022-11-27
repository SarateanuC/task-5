package com.example.task5.controller;

import com.example.task5.dbo.UniversityDbo;
import com.example.task5.dto.UniversityDto;
import com.example.task5.service.UniversityService;
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
    public List<UniversityDto> selectAllStudents() {
        return universityService.selectAll();
    }

    @GetMapping("/by-id")
    public UniversityDto selectById(@RequestParam("id") UUID id) {
        return universityService.selectById(id);
    }

}
