package com.example.task5.controller;

import com.example.task5.service.impl.ProfessorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/professor")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorServiceImpl professorServiceImpl;
}
