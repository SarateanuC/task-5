package com.example.task5.dbo;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UniversityDbo {
    private UUID university_id;
    private String name;
    private List<CourseDbo> courses;
    private List<StudentDbo> students;
    private AddressDbo addressDbo;
}
