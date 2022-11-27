package com.example.task5.service.impl;

import com.example.task5.dbo.StudentDbo;
import com.example.task5.dto.StudentDto;
import com.example.task5.mapper.StudentMapper;
import com.example.task5.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;

    @Override
    public List<StudentDto> selectAll() {
        return studentMapper.selectAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto selectById(UUID id) {
        return convertToDto(studentMapper.selectById(id).orElseThrow());
    }

    private StudentDto convertToDto(StudentDbo studentDbo) {
        return StudentDto.builder()
                .student_id(studentDbo.getStudent_id())
                .addressDbo(studentDbo.getAddressDbo())
                .age(studentDbo.getAge())
                .courses(studentDbo.getCourses())
                .university(studentDbo.getUniversity())
                .lastname(studentDbo.getLastname())
                .firstname(studentDbo.getFirstname())
                .build();
    }
}
