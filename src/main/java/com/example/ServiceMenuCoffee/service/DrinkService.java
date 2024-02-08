package com.example.ServiceMenuCoffee.service;

import com.example.ServiceMenuCoffee.model.dto.DrinkDto;
import com.example.ServiceMenuCoffee.model.request.CreateDrinkRequest;
import com.example.ServiceMenuCoffee.model.request.CreateDrinkTypeRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DrinkService {
    DrinkDto save(DrinkDto dto);
    DrinkDto getById(Long id);
    List<DrinkDto> getAll();
    DrinkDto create(CreateDrinkRequest request);
}
