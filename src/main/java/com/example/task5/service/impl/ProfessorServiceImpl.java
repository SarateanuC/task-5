package com.example.task5.service.impl;

import com.example.task5.mapper.ProfessorMapper;
import com.example.task5.model.ProfessorDbo;
import com.example.task5.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorMapper professorMapper;

    public List<ProfessorDbo> selectAll(){
        return professorMapper.selectAll();
    }
}
