package com.example.task5.model;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDbo {
    private UUID student_id;
    private String firstname;
    private String lastname;
    private Integer age;
    private UUID address_id;
    private List<CourseDbo> courses;
    private List<UniversityDbo> universities;
}
