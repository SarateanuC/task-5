package com.example.task5.model;

import lombok.*;

import java.util.UUID;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDbo {
    private UUID address_id;
    private String name;
}
