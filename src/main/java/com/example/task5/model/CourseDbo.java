package com.example.task5.model;

import lombok.*;

import java.util.UUID;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDbo {
    private UUID course_id;
    private String name;
}
