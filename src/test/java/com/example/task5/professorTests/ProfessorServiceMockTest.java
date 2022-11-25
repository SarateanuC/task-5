package com.example.task5.professorTests;

import com.example.task5.mapper.ProfessorMapper;
import com.example.task5.model.CourseDbo;
import com.example.task5.model.ProfessorDbo;
import com.example.task5.model.UniversityDbo;
import com.example.task5.service.impl.ProfessorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.Optional.of;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ProfessorServiceMockTest {
    @Mock
    private ProfessorMapper professorMapper;

    @InjectMocks
    private ProfessorServiceImpl professorService;

    @Test
    public void selectByIdSuccessTest() {
        ProfessorDbo professorDbo = ProfessorDbo.builder()
                .professor_id(randomUUID())
                .course_id(randomUUID())
                .firstname("A1")
                .lastname("A1")
                .university(UniversityDbo.builder()
                        .name("UTM")
                        .university_id(UUID.randomUUID())
                        .build())
                .build();
        when(professorMapper.selectById(any())).thenReturn(of(professorDbo));
        assertThat(professorService
                .selectById(randomUUID()).getFirstname()).isEqualTo(professorDbo.getFirstname());
    }

    @Test
    public void selectByIdEmptyOptionalTest() {
        when(professorMapper.selectById(any())).thenReturn(Optional.empty());
        assertThatThrownBy(() -> professorService
                .selectById(randomUUID()));
    }

    @Test
    public void selectByAllSuccessTest() {
        ProfessorDbo professorDbo1 = ProfessorDbo.builder()
                .professor_id(randomUUID())
                .course_id(randomUUID())
                .firstname("A1")
                .lastname("A1")
                .university(UniversityDbo.builder()
                        .name("UTM")
                        .university_id(UUID.randomUUID())
                        .build())
                .build();

        ProfessorDbo professorDbo2 = ProfessorDbo.builder()
                .professor_id(randomUUID())
                .course_id(randomUUID())
                .firstname("A2")
                .lastname("A2")
                .university(UniversityDbo.builder()
                        .name("UTM")
                        .university_id(UUID.randomUUID())
                        .build())
                .build();
        when(professorMapper.selectAll()).thenReturn(List.of(professorDbo1, professorDbo2));
        assertThat(professorService
                .selectAll().get(0).getFirstname()).isEqualTo(professorDbo1.getFirstname());
        assertThat(professorService
                .selectAll().size()).isEqualTo(2);
    }

    @Test
    public void selectByAllEmptyListTest() {
        when(professorMapper.selectAll()).thenReturn(Collections.emptyList());
        assertThat(professorService.selectAll()).isEmpty();
    }
}
