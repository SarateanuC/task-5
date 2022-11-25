package com.example.task5.service.impl;

import com.example.task5.mapper.ProfessorMapper;
import com.example.task5.model.ProfessorDbo;
import com.example.task5.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorMapper professorMapper;

    @Override
    public List<ProfessorDbo> selectAll() {
        return professorMapper.selectAll();
    }

    @Override
    public ProfessorDbo selectById(UUID id) {
        return professorMapper.selectById(id).orElseThrow();
    }
}
