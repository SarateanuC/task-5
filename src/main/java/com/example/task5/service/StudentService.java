package com.example.task5.service;

import com.example.task5.dto.StudentDto;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    List<StudentDto> selectAll();

    StudentDto selectById(UUID id);

}
