package com.example.ServiceMenuCoffee.model.dto;

import com.example.ServiceMenuCoffee.model.entity.DrinkType;
import com.example.ServiceMenuCoffee.model.entity.Ingredient;
import com.example.ServiceMenuCoffee.model.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@ToString
public class DrinkDto {
    Long id;
    LocalDateTime createdDate;
    LocalDateTime updatedDate;
    DrinkTypeDto drinkTypeDto; // Make sure it's DrinkTypeDto, not DrinkType
    Status status;
    String name;
    int price;
    int size;

    public void setDrinkTypeDto(DrinkTypeDto drinkTypeDto) {
        this.drinkTypeDto = drinkTypeDto;
    }
}
