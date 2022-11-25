package com.example.task5.controller;

import com.example.task5.model.StudentDbo;
import com.example.task5.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/all")
    public List<StudentDbo> selectAllStudents() {
        return studentService.selectAll();
    }

    @GetMapping("/by-id")
    public StudentDbo selectById(@RequestParam("student-id") UUID id) {
        return studentService.selectById(id);
    }
}
