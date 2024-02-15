package com.example.ServiceMenuCoffee.model.mapper;

import com.example.ServiceMenuCoffee.model.dto.DrinkDto;
import com.example.ServiceMenuCoffee.model.dto.DrinkIngredientsDto;
import com.example.ServiceMenuCoffee.model.entity.Drink;
import com.example.ServiceMenuCoffee.model.entity.DrinkIngredients;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DrinkIngredientsMapper extends BaseMapper<DrinkIngredients, DrinkIngredientsDto> {
    DrinkIngredientsMapper INSTANCE = Mappers.getMapper(DrinkIngredientsMapper.class);
}
