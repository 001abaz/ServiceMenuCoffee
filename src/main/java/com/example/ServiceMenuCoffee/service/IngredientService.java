package com.example.ServiceMenuCoffee.service;

import com.example.ServiceMenuCoffee.model.dto.IngredientDto;
import com.example.ServiceMenuCoffee.model.entity.Ingredient;
import com.example.ServiceMenuCoffee.model.request.CreateIngredientRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IngredientService {
    IngredientDto save(Ingredient entity);
    IngredientDto getById(Long id);
    List<IngredientDto> getAll();
    IngredientDto create(CreateIngredientRequest request);
}
