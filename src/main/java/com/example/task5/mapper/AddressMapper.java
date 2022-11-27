package com.example.task5.mapper;

import com.example.task5.dbo.AddressDbo;
import com.example.task5.mapper.typeHandler.UuidTypeHandler;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface AddressMapper {
    @Select("Select * from address where address_id = #{address_id}")
    @Results({
            @Result(id = true, property = "address_id", column = "address_id",
                    jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class),
            @Result(property = "name", column = "name")})
    AddressDbo findById(String address_id);
}
