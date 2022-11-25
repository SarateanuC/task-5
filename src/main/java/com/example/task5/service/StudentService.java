package com.example.task5.service;

import com.example.task5.model.ProfessorDbo;
import com.example.task5.model.StudentDbo;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    List<StudentDbo> selectAll();

    StudentDbo selectById(UUID id);

}
