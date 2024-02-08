package com.example.ServiceMenuCoffee.model.mapper;


import com.example.ServiceMenuCoffee.model.dto.DrinkTypeDto;
import com.example.ServiceMenuCoffee.model.entity.DrinkType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DrinkTypeMapper extends BaseMapper<DrinkType, DrinkTypeDto> {
    DrinkTypeMapper INSTANCE = Mappers.getMapper(DrinkTypeMapper.class);
}
