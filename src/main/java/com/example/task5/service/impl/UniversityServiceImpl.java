package com.example.task5.service.impl;

import com.example.task5.dbo.UniversityDbo;
import com.example.task5.dto.UniversityDto;
import com.example.task5.mapper.UniversityMapper;
import com.example.task5.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {
    private final UniversityMapper universityMapper;

    @Override
    public List<UniversityDto> selectAll() {
        return universityMapper.selectAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UniversityDto selectById(UUID id) {
        return convertToDto(universityMapper.selectById(id).orElseThrow());
    }

    private UniversityDto convertToDto(UniversityDbo universityDbo) {
        return UniversityDto.builder()
                .university_id(universityDbo.getUniversity_id())
                .name(universityDbo.getName())
                .students(universityDbo.getStudents())
                .courses(universityDbo.getCourses())
                .build();
    }
}
