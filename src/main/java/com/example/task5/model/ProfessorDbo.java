package com.example.task5.model;

import lombok.*;

import java.util.UUID;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDbo {
    private UUID professor_id;
    private String firstname;
    private String lastname;
    private UUID course_id;
    private UniversityDbo university;
}
