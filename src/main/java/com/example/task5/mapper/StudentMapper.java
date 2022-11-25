package com.example.task5.mapper;

import com.example.task5.mapper.typeHandler.UuidTypeHandler;
import com.example.task5.model.CourseDbo;
import com.example.task5.model.StudentDbo;
import com.example.task5.model.UniversityDbo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM students")
    @Results(value = {
            @Result(id = true, property = "student_id", column = "student_id", jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class),
            @Result(property = "firstname", column = "firstname"),
            @Result(property = "lastname", column = "lastname"),
            @Result(property = "age", column = "age"),
            @Result(property = "address_id", column = "address_id", jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class),
            @Result(property = "courses", column = "course_id", javaType = List.class,
                    many = @Many(select = "selectCoursesByStudent")),
//            @Result(property = "universities", column = "student_id", javaType = UniversityDbo.class,
//                    many = @Many(select = "selectUniversitiesByStudent"))
    })
    List<StudentDbo> selectAll();

    @Select("SELECT * FROM students WHERE student_id = #{id}")
    @Results(value = {
            @Result(id = true, property = "student_id", column = "student_id", jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class),
            @Result(property = "firstname", column = "firstname"),
            @Result(property = "lastname", column = "lastname"),
            @Result(property = "age", column = "age"),
            @Result(property = "address_id", column = "address_id", jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class),
//            @Result(property = "courses", column = "student_id", javaType = List.class,
//                    many = @Many(select = "selectCoursesByStudent")),
//            @Result(property = "universities", column = "student_id", javaType = UniversityDbo.class,
//                    many = @Many(select = "selectUniversitiesByStudent"))
    })
    Optional<StudentDbo> selectById(@Param("id") UUID student_id);


    @Select("SELECT course.course_id,course.name " +
            "FROM student_course  " +
            "LEFT OUTER JOIN course " +
            "ON student_course.course_id = course.course_id " +
            "WHERE student_id = #{student_id}")
    @Results(value = {
            @Result(id=true, property = "course_id", column = "course_id", jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class),
            @Result(property = "name", column = "name")
    })
    List<CourseDbo> selectCoursesByStudent(@Param("student_id") UUID student_id);

    @Select("Select universities.university_id,universities.name,universities.address_id " +
            "from professor_university " +
            "Left outer join universities " +
            "on professor_university.university_id = universities.university_id " +
            "where professor_id = #{student_id}")
    @Results(value = {
            @Result(id=true, property = "university_id", column = "university_id",jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class),
            @Result(property = "name", column = "name"),
            @Result(property = "address", column = "address_id",jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class)
    })
    List<UniversityDbo> selectUniversitiesByStudent(@Param("student_id")UUID student_id);
}
