package com.example.task5.service.impl;

import com.example.task5.mapper.StudentMapper;
import com.example.task5.model.StudentDbo;
import com.example.task5.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;
@Override
    public List<StudentDbo> selectAll(){
        return studentMapper.selectAll();
    }
    @Override
    public StudentDbo selectById(UUID id){
        return studentMapper.selectById(id).orElseThrow();
    }
}
