package com.example.task5.mapper;

import com.example.task5.model.UniversityDbo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UniversityMapper {
    @Select(" ")
    List<UniversityDbo> selectAll();
}
