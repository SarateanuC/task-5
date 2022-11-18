package com.example.task5.model;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UniversityDbo {
    private UUID university_id;
    private String name;
    private UUID address_id;
    private List<CourseDbo> courses;
    private List<ProfessorDbo> professors;
}
