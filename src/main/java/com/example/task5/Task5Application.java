package com.example.task5;

import com.example.task5.dbo.AddressDbo;
import com.example.task5.dbo.CourseDbo;
import com.example.task5.dbo.StudentDbo;
import com.example.task5.dbo.UniversityDbo;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@MappedTypes({UniversityDbo.class, StudentDbo.class, CourseDbo.class, AddressDbo.class})
@MapperScan("com.example.task5.mapper")
@SpringBootApplication
public class Task5Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(Task5Application.class, args);

    }

}
