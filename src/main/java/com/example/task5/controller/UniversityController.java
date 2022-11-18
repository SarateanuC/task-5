package com.example.task5.controller;

import com.example.task5.service.impl.UniversityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/university")
@RequiredArgsConstructor
public class UniversityController {
    private final UniversityServiceImpl universityServiceImpl;
}
