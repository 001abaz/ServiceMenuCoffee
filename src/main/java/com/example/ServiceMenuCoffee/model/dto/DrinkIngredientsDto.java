package com.example.ServiceMenuCoffee.model.dto;

import com.example.ServiceMenuCoffee.model.enums.Status;
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
public class DrinkIngredientsDto {
    Long id;
    LocalDateTime createdDate;
    LocalDateTime updatedDate;
    Status status;

    DrinkDto drinkDto;

    IngredientDto ingredientDto;
}

