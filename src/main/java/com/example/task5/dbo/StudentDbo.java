package com.example.task5.dbo;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDbo {
    private UUID student_id;
    private String firstname;
    private String lastname;
    private Integer age;
    private UUID university;
    private AddressDbo addressDbo;
    private List<CourseDbo> courses;
}
