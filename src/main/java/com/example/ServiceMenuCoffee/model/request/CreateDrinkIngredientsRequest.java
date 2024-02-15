package com.example.ServiceMenuCoffee.model.request;

import com.example.ServiceMenuCoffee.model.dto.DrinkDto;
import com.example.ServiceMenuCoffee.model.dto.IngredientDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateDrinkIngredientsRequest {

    DrinkDto drinkDto;
    String name;
    int price;
    IngredientDto ingredientDto;
}
