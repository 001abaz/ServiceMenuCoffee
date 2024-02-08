package com.example.ServiceMenuCoffee.model.dto;

import com.example.ServiceMenuCoffee.model.entity.DrinkType;
import com.example.ServiceMenuCoffee.model.entity.Ingredient;
import com.example.ServiceMenuCoffee.model.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DrinkDto {
    Long id;
    LocalDateTime createdDate;
    LocalDateTime updatedDate;
    Status status;
    String drinkType;
    String name;
    int price;
    String ingredient;
    int size;
}
