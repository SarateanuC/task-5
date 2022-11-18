package com.example.task5.service.impl;

import com.example.task5.mapper.UniversityMapper;
import com.example.task5.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {
    private final UniversityMapper universityMapper;
}
