package com.example.task5.mapper;

import com.example.task5.model.AddressDbo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface AddressMapper {
    @Select("SELECT * FROM address")
    List<AddressDbo> findAll();

    @Select("SELECT * FROM address where address_id = #{id}")
    Optional<AddressDbo> findById(@Param("id") UUID id);
}
