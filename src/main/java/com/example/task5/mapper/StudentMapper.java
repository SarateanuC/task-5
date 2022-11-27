package com.example.task5.mapper;

import com.example.task5.dbo.CourseDbo;
import com.example.task5.dbo.StudentDbo;
import com.example.task5.mapper.typeHandler.UuidTypeHandler;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM students")
    @Results(value = {
            @Result(id = true, property = "student_id", column = "student_id",
                    jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class),
            @Result(property = "firstname", column = "firstname"),
            @Result(property = "lastname", column = "lastname"),
            @Result(property = "age", column = "age"),
            @Result(property = "addressDbo", column = "address_id",
                    one = @One(select = "com.example.task5.mapper.AddressMapper.findById")),
            @Result(property = "courses", column = "courses", javaType = List.class,
                    many = @Many(select = "selectCourseByStudent"))
    })
    List<StudentDbo> selectAll();

    @Select("SELECT * FROM students WHERE student_id = #{id}")
    @Results(value = {
            @Result(id = true, property = "student_id", column = "student_id",
                    jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class),
            @Result(property = "firstname", column = "firstname"),
            @Result(property = "lastname", column = "lastname"),
            @Result(property = "age", column = "age"),
            @Result(property = "addressDbo", column = "address_id",
                    one = @One(select = "com.example.task5.mapper.AddressMapper.findById")),
            @Result(property = "courses", column = "student_id", javaType = List.class,
                    many = @Many(select = "selectCoursesByStudent"))
    })
    Optional<StudentDbo> selectById(@Param("id") UUID student_id);

    @Select("SELECT * FROM course " +
            "LEFT JOIN student_course sc on course.course_id = sc.course_id " +
            "WHERE student_id = #{student_id}")
    @Results({
            @Result(id = true, property = "course_id", column = "course_id",
                    jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class),
            @Result(property = "name", column = "name"),
            @Result(property = "students", column = "course_id", javaType = List.class,
                    many = @Many(select = "selectStudentsByCourse"))
    })
    List<CourseDbo> selectCoursesByStudent(String student_id);

    @Select("SELECT * FROM students " +
            "LEFT JOIN student_course sc on students.student_id = sc.student_id " +
            "WHERE course_id = #{course_id}")
    @Results({
            @Result(id = true, property = "student_id", column = "student_id",
                    jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class),
            @Result(property = "firstname", column = "firstname"),
            @Result(property = "lastname", column = "lastname"),
            @Result(property = "age", column = "age"),
            @Result(property = "addressDbo", column = "address_id",
                    one = @One(select = "com.example.task5.mapper.AddressMapper.findById"))
    })
    List<StudentDbo> selectStudentsByCourse(String student_id);
}
