package com.example.task5.studentTests;

import com.example.task5.mapper.StudentMapper;
import com.example.task5.model.CourseDbo;
import com.example.task5.model.StudentDbo;
import com.example.task5.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.of;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class StudentServiceMockTests {
    @Mock
    private StudentMapper studentMapper;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    public void selectByIdSuccessTest() {
        StudentDbo studentDbo = StudentDbo.builder()
                .student_id(randomUUID())
                .address_id(randomUUID())
                .lastname("last")
                .firstname("first")
                .courses(List.of(CourseDbo.builder()
                        .course_id(randomUUID())
                        .name("Curs")
                        .build()))
                .build();
        when(studentMapper.selectById(any())).thenReturn(of(studentDbo));
        assertThat(studentService.selectById(randomUUID()).getFirstname()).isEqualTo(studentDbo.getFirstname());
    }

    @Test
    public void selectByIdEmptyOptionalTest() {
        when(studentMapper.selectById(any())).thenReturn(Optional.empty());
        assertThatThrownBy(() -> studentService.selectById(randomUUID()));
    }

    @Test
    public void selectByAllSuccessTest() {
        StudentDbo studentDbo1 = StudentDbo.builder()
                .student_id(randomUUID())
                .address_id(randomUUID())
                .lastname("last1")
                .firstname("first1")
                .courses(List.of(CourseDbo.builder()
                        .course_id(randomUUID())
                        .name("Curs")
                        .build()))
                .build();
        StudentDbo studentDbo2 = StudentDbo.builder()
                .student_id(randomUUID())
                .address_id(randomUUID())
                .lastname("last2")
                .firstname("first3")
                .courses(List.of(CourseDbo.builder()
                        .course_id(randomUUID())
                        .name("Curs")
                        .build()))
                .build();
        when(studentMapper.selectAll()).thenReturn(List.of(studentDbo1, studentDbo2));
        assertThat(studentService.selectAll().get(0).getFirstname()).isEqualTo(studentDbo1.getFirstname());
        assertThat(studentService.selectAll().size()).isEqualTo(2);
    }

    @Test
    public void selectByAllEmptyListTest() {
        when(studentMapper.selectAll()).thenReturn(Collections.emptyList());
        assertThat(studentService.selectAll()).isEmpty();
    }
}
