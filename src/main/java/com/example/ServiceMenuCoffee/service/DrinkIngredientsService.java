package com.example.ServiceMenuCoffee.service;

import com.example.ServiceMenuCoffee.model.dto.DrinkDto;
import com.example.ServiceMenuCoffee.model.dto.DrinkIngredientsDto;
import com.example.ServiceMenuCoffee.model.entity.DrinkIngredients;
import com.example.ServiceMenuCoffee.model.request.CreateDrinkIngredientsRequest;
import com.example.ServiceMenuCoffee.model.request.CreateDrinkRequest;

import java.util.List;

public interface DrinkIngredientsService {
    void save(DrinkIngredients entity);
    DrinkIngredientsDto getById(Long id);
    List<DrinkIngredientsDto> getAll();
    DrinkIngredientsDto create(Long drinkId, Long ingredientId);
}
