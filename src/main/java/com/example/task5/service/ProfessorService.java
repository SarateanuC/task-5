package com.example.task5.service;

import com.example.task5.model.ProfessorDbo;

import java.util.List;
import java.util.UUID;

public interface ProfessorService {
    List<ProfessorDbo> selectAll();

    ProfessorDbo selectById(UUID id);
}
