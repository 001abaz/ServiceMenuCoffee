package com.example.ServiceMenuCoffee.model.request;

import com.example.ServiceMenuCoffee.model.dto.DrinkTypeDto;
import com.example.ServiceMenuCoffee.model.dto.IngredientDto;
import com.example.ServiceMenuCoffee.model.entity.DrinkType;
import com.example.ServiceMenuCoffee.model.entity.Ingredient;
import com.example.ServiceMenuCoffee.model.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateDrinkRequest {

    String drinkTypeName;
    String name;
    int price;
    int size;
}
