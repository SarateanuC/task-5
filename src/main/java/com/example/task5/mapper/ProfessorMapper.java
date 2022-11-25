package com.example.task5.mapper;

import com.example.task5.mapper.typeHandler.UuidTypeHandler;
import com.example.task5.model.ProfessorDbo;
import com.example.task5.model.UniversityDbo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface ProfessorMapper {

    @Select("select * from professor")
    @Results(value = {
            @Result(id=true, property = "professor_id", column = "professor_id",jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class),
            @Result(property = "course_id", column = "course_id",jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class),
            @Result(property="university",column ="professor_id",javaType= UniversityDbo.class,
                    one=@One(select="selectAllByProfessor"))
    })
    List<ProfessorDbo> selectAll();

    @Select("select * from professor where professor_id = #{id}")
    @Results(value = {
            @Result(id=true, property = "professor_id", column = "professor_id",jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class),
            @Result(property = "course_id", column = "course_id",jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class),
            @Result(property="university",column ="professor_id",javaType= UniversityDbo.class,
                    one=@One(select="selectAllByProfessor",fetchType = FetchType.LAZY))
    })
    Optional<ProfessorDbo> selectById(@Param("id") UUID id);

    @Select("Select universities.university_id,universities.name,universities.address_id " +
            "from professor_university " +
            "Left outer join universities " +
            "on professor_university.university_id = universities.university_id " +
            "where professor_id = #{id}")
    @Results(value = {
            @Result(id=true, property = "university_id", column = "university_id",jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class),
            @Result(property = "name", column = "name"),
            @Result(property = "address", column = "address_id",jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class)
    })
    UniversityDbo selectAllByProfessor(@Param("id") UUID id);
}
