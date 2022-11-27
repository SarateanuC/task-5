package com.example.task5.service;

import com.example.task5.dto.UniversityDto;

import java.util.List;
import java.util.UUID;

public interface UniversityService {
    List<UniversityDto> selectAll();

    UniversityDto selectById(UUID id);
}
