package com.example.ServiceMenuCoffee.model.mapper;


import com.example.ServiceMenuCoffee.model.dto.IngredientDto;
import com.example.ServiceMenuCoffee.model.entity.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IngredientMapper extends BaseMapper<Ingredient, IngredientDto> {
    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);
}
