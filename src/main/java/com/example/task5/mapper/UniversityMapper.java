package com.example.task5.mapper;

import com.example.task5.dbo.CourseDbo;
import com.example.task5.dbo.StudentDbo;
import com.example.task5.dbo.UniversityDbo;
import com.example.task5.mapper.typeHandler.UuidTypeHandler;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface UniversityMapper {
    @Select("Select * from universities")
    @Results(value = {
            @Result(id = true, property = "university_id", column = "university_id",
                    jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class),
            @Result(property = "name", column = "name"),
            @Result(property = "addressDbo", column = "address_id",
                    one = @One(select = "com.example.task5.mapper.AddressMapper.findById")),
            @Result(property = "courses", column = "university_id", javaType = List.class,
                    many = @Many(select = "selectCourseByUniversity")),
            @Result(property = "students", column = "university_id", javaType = List.class,
                    many = @Many(select = "selectStudentsByUniversity"))
    })
    List<UniversityDbo> selectAll();

    @Select("Select * from universities where university_id = #{id}")
    @Results(value = {
            @Result(id = true, property = "university_id", column = "university_id",
                    jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class),
            @Result(property = "name", column = "name"),
            @Result(property = "courses", column = "university_id", javaType = List.class,
                    many = @Many(select = "selectCourseByUniversity")),
            @Result(property = "students", column = "university_id", javaType = List.class,
                    many = @Many(select = "selectStudentsByUniversity")),
            @Result(property = "addressDbo", column = "address_id",
                    one = @One(select = "com.example.task5.mapper.AddressMapper.findById"))
    })
    Optional<UniversityDbo> selectById(@Param("id") UUID id);

    @Select("Select * from course where university = #{university_id}")
    @Results({
            @Result(id = true, property = "course_id", column = "course_id",
                    jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class),
            @Result(property = "name", column = "name")
    })
    CourseDbo selectCourseByUniversity(String university_id);

    @Select("Select * from students where university_id = #{university_id}")
    @Results(value = {
            @Result(id = true, property = "student_id", column = "student_id",
                    jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class),
            @Result(property = "firstname", column = "firstname"),
            @Result(property = "lastname", column = "lastname"),
            @Result(property = "age", column = "age"),
            @Result(property = "addressDbo", column = "address_id",
                    one = @One(select = "com.example.task5.mapper.AddressMapper.findById"))
    })
    StudentDbo selectStudentsByUniversity(String university_id);
}
