package com.example.task5;

import com.example.task5.mapper.ProfessorMapper;
import com.example.task5.model.*;
import com.example.task5.service.ProfessorService;
import com.example.task5.service.impl.ProfessorServiceImpl;
import com.example.task5.service.impl.StudentServiceImpl;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.UUID;
@MappedTypes({UniversityDbo.class, StudentDbo.class, CourseDbo.class, AddressDbo.class,ProfessorDbo.class})
@MapperScan("com.example.task5.mapper")
@SpringBootApplication
public class Task5Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(Task5Application.class, args);
    }

}
