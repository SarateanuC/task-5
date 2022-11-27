package com.example.task5.dto;

import com.example.task5.dbo.AddressDbo;
import com.example.task5.dbo.CourseDbo;
import com.example.task5.dbo.StudentDbo;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UniversityDto {
    private UUID university_id;
    private String name;
    private List<CourseDbo> courses;
    private List<StudentDbo> students;
    private AddressDbo addressDbo;
}
