package com.example.ServiceMenuCoffee.model.dto;

import com.example.ServiceMenuCoffee.model.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@ToString
public class DrinkTypeDto {
    Long id;
    LocalDateTime createdDate;
    LocalDateTime updatedDate;
    Status status;
    String name;
}
