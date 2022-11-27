package com.example.task5.dbo;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDbo {
    private UUID course_id;
    private String name;
    private UUID university;
    private List<StudentDbo> students;
}
