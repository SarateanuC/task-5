package com.example.task5.mapper;

import com.example.task5.model.StudentDbo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select(" ")
    List<StudentDbo> selectAll();
}
