package com.example.task5.service;

import com.example.task5.model.ProfessorDbo;
import com.example.task5.model.UniversityDbo;

import java.util.List;
import java.util.UUID;

public interface UniversityService {
    List<UniversityDbo> selectAll();

    UniversityDbo selectById(UUID id);
}
