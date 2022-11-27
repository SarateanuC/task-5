package com.example.task5.universityTests;

import com.example.task5.dbo.UniversityDbo;
import com.example.task5.dto.UniversityDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@SqlGroup(
        @Sql(scripts = {"/sql/20221125_create-address.sql",
                "/sql/20221125_insert-address.sql",
                "/sql/20221125_create-university.sql",
                "/sql/20221125_insert_university.sql",
                "/sql/20221125_create-course.sql",
                "/sql/20221125_insert-course.sql",
                "/sql/20221125_create_students.sql",
                "/sql/20221125_insert-student.sql"
        }))
public class UniversityIntegrationTest {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    void selectById() {
        MvcResult mvcResult = mockMvc.perform(get("/api/university/by-id")
                        .param("id", "ab3daa2c-6d93-11ed-a1eb-0242ac120002")
                        .contentType("application/json"))
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();

        UniversityDto universityDto = objectMapper.readValue(contentAsString, UniversityDto.class);
        Assertions.assertThat(universityDto.getName()).isEqualTo("USM");
        Assertions.assertThat(universityDto.getCourses().size()).isEqualTo(1);
        Assertions.assertThat(universityDto.getStudents().size()).isEqualTo(1);
    }

    @Test
    @SneakyThrows
    void selectAll() {
        MvcResult mvcResult = mockMvc.perform(get("/api/university/all")
                        .contentType("application/json"))
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();

        List<UniversityDto> universityDtos = List.of(objectMapper.readValue(contentAsString, UniversityDto[].class));
        Assertions.assertThat(universityDtos.size()).isEqualTo(2);
    }
}
