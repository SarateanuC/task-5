package com.example.task5.mapper;

import com.example.task5.model.CourseDbo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface CourseMapper {
    @Select("Select * from course")
    List<CourseDbo> findAll();

    @Select("Select * from course where course_id = #{id}")
    Optional<CourseDbo> findById(@Param("id") UUID id);
}
