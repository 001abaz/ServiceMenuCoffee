package com.example.ServiceMenuCoffee.model.mapper;

import com.example.ServiceMenuCoffee.model.dto.DrinkDto;
import com.example.ServiceMenuCoffee.model.entity.Drink;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DrinkMapper extends BaseMapper<Drink, DrinkDto> {
    DrinkMapper INSTANCE = Mappers.getMapper(DrinkMapper.class);
}
