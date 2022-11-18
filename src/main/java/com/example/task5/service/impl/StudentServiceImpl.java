package com.example.task5.service.impl;

import com.example.task5.mapper.StudentMapper;
import com.example.task5.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;
}
