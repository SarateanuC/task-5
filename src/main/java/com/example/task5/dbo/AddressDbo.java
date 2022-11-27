package com.example.task5.dbo;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDbo {
    private UUID address_id;
    private String name;
}
