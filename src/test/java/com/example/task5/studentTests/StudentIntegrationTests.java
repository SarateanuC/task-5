package com.example.task5.studentTests;

import com.example.task5.dbo.StudentDbo;
import com.example.task5.dto.StudentDto;
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
                "/sql/20221125_insert-student.sql",
                "/sql/20221125_create-student-course.sql",
                "/sql/20221125_insert-student-course.sql"
        }))
class StudentIntegrationTests {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    void selectStudentById() {
        MvcResult mvcResult = mockMvc.perform(get("/api/student/by-id")
                        .param("student-id", "a1fc5242-6726-11ed-9022-0242ac120002")
                        .contentType("application/json"))
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();

        StudentDto studentDto = objectMapper.readValue(contentAsString, StudentDto.class);
        Assertions.assertThat(studentDto.getFirstname()).isEqualTo("Ion");
        Assertions.assertThat(studentDto.getAddressDbo().getName()).isEqualTo("Chisinau, str. Corlateni");
        Assertions.assertThat(studentDto.getCourses().size()).isEqualTo(1);
        Assertions.assertThat(studentDto.getCourses().get(0).getStudents().size()).isEqualTo(1);
    }

    @Test
    @SneakyThrows
    void selectAll() {
        MvcResult mvcResult = mockMvc.perform(get("/api/student/all")
                        .contentType("application/json"))
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();

        List<StudentDto> studentDtos = List.of(objectMapper.readValue(contentAsString, StudentDto[].class));
        Assertions.assertThat(studentDtos.size()).isEqualTo(2);
    }

}
