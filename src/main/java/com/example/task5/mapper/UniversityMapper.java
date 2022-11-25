package com.example.task5.mapper;

import com.example.task5.mapper.typeHandler.UuidTypeHandler;
import com.example.task5.model.CourseDbo;
import com.example.task5.model.UniversityDbo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface UniversityMapper {
    @Select("SELECT * FROM universities")
    @Results({
            @Result(id=true, property = "id", column = "university_id"),
            @Result(property = "name", column = "name"),
            @Result(property="address", column="address_id",
                    one=@One(select="com.example.AddressMapper.findById")),
           @Result(property="courses", column = "university_id", javaType = List.class,
                    many = @Many(select="selectAllByUniversity"))
    })
    List<UniversityDbo> selectAll();

    @Select("SELECT * FROM universities where university_id = #{id}")
    @Results({
            @Result(id=true, property = "id", column = "university_id"),
            @Result(property = "name", column = "name"),
            @Result(property="address", column="address_id",
                    one=@One(select="com.example.AddressMapper.findById")),
            @Result(property="courses", column = "university_id", javaType = List.class,
                    many = @Many(select="selectAllByUniversity"))
    })
    Optional<UniversityDbo> selectById(@Param("id")UUID id);

    @Select("SELECT course.course_id, course.name " +
            " FROM course_university " +
            " LEFT OUTER JOIN course " +
            " ON course_university.course_id = course.course_id " +
            " WHERE university_id = #{id}")
    @Results(value = {
            @Result(property = "course_id", column = "course_id", jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class),
            @Result(property = "name", column = "name", jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class)
    })
    CourseDbo selectAllByUniversity(@Param("id") UUID id);
}
