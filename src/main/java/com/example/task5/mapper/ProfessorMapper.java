package com.example.task5.mapper;

import com.example.task5.model.ProfessorDbo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProfessorMapper {

    @Select(" ")
    List<ProfessorDbo> selectAll();
}
