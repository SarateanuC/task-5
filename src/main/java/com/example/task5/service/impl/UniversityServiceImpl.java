package com.example.task5.service.impl;

import com.example.task5.mapper.UniversityMapper;
import com.example.task5.model.UniversityDbo;
import com.example.task5.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {
    private final UniversityMapper universityMapper;

    @Override
    public List<UniversityDbo> selectAll() {
        return universityMapper.selectAll();
    }

    @Override
    public UniversityDbo selectById(UUID id) {
        return universityMapper.selectById(id).orElseThrow();
    }
}
