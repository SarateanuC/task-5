package com.example.task5.universityTests;

import com.example.task5.dbo.AddressDbo;
import com.example.task5.dbo.UniversityDbo;
import com.example.task5.mapper.UniversityMapper;
import com.example.task5.service.impl.UniversityServiceImpl;
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
public class UniversityServiceMockTest {
    @Mock
    private UniversityMapper universityMapper;

    @InjectMocks
    private UniversityServiceImpl universityService;

    @Test
    public void selectByIdSuccessTest() {
        UniversityDbo universityDbo = UniversityDbo.builder()
                .university_id(randomUUID())
                .addressDbo(AddressDbo.builder().name("name")
                        .address_id(UUID.randomUUID()).build())
                .name("UTM")
                .build();
        when(universityMapper.selectById(any())).thenReturn(of(universityDbo));
        assertThat(universityService.selectById(randomUUID()).getName()).isEqualTo(universityDbo.getName());
    }

    @Test
    public void selectByIdEmptyOptionalTest() {
        when(universityMapper.selectById(any())).thenReturn(Optional.empty());
        assertThatThrownBy(() -> universityService.selectById(randomUUID()));
    }

    @Test
    public void selectByAllSuccessTest() {
        UniversityDbo universityDbo1 = UniversityDbo.builder()
                .university_id(UUID.randomUUID())
                .addressDbo(AddressDbo.builder().name("name")
                        .address_id(UUID.randomUUID()).build())
                .name("UTM")
                .build();
        UniversityDbo universityDbo2 = UniversityDbo.builder()
                .university_id(UUID.randomUUID())
                .addressDbo(AddressDbo.builder().name("name")
                        .address_id(UUID.randomUUID()).build())
                .name("USM")
                .build();

        when(universityMapper.selectAll()).thenReturn(List.of(universityDbo1, universityDbo2));
        assertThat(universityService.selectAll().get(0).getName()).isEqualTo(universityDbo1.getName());
        assertThat(universityService.selectAll().size()).isEqualTo(2);
    }

    @Test
    public void selectByAllEmptyListTest() {
        when(universityMapper.selectAll()).thenReturn(Collections.emptyList());
        assertThat(universityService.selectAll()).isEmpty();
    }
}
