package com.example.ServiceMenuCoffee.service;

import com.example.ServiceMenuCoffee.model.dto.DrinkDto;
import com.example.ServiceMenuCoffee.model.dto.DrinkTypeDto;
import com.example.ServiceMenuCoffee.model.entity.DrinkType;
import com.example.ServiceMenuCoffee.model.request.CreateDrinkTypeRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DrinkTypeService {
    DrinkTypeDto save(DrinkType entity);
    DrinkTypeDto getById(Long id);
    List<DrinkTypeDto> getAll();
    DrinkTypeDto create(CreateDrinkTypeRequest request);
    DrinkTypeDto getByName(String name);
}
