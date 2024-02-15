package com.example.ServiceMenuCoffee.service.impl;

import com.example.ServiceMenuCoffee.model.dto.DrinkDto;
import com.example.ServiceMenuCoffee.model.dto.DrinkIngredientsDto;
import com.example.ServiceMenuCoffee.model.entity.DrinkIngredients;
import com.example.ServiceMenuCoffee.model.enums.Status;
import com.example.ServiceMenuCoffee.model.mapper.DrinkIngredientsMapper;
import com.example.ServiceMenuCoffee.model.mapper.DrinkMapper;
import com.example.ServiceMenuCoffee.model.mapper.IngredientMapper;
import com.example.ServiceMenuCoffee.model.request.CreateDrinkIngredientsRequest;
import com.example.ServiceMenuCoffee.repository.DrinkIngredientsRepository;
import com.example.ServiceMenuCoffee.service.DrinkIngredientsService;
import com.example.ServiceMenuCoffee.service.DrinkService;
import com.example.ServiceMenuCoffee.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DrinkIngredientsServiceImpl implements DrinkIngredientsService {
    private final DrinkIngredientsRepository repository;
    private final DrinkService drinkService;
    private final IngredientService ingredientService;
    @Override
    public void save(DrinkIngredients entity) {

        repository.save(entity);
    }

    @Override
    public DrinkIngredientsDto getById(Long id) {
        return DrinkIngredientsMapper.INSTANCE.toDto(repository.findById(id).orElseThrow());
    }

    @Override
    public List<DrinkIngredientsDto> getAll() {
        return DrinkIngredientsMapper.INSTANCE.toDtos(repository.findAll());
    }

    @Override
    public DrinkIngredientsDto create(Long drinkId, Long ingredientId) {
        DrinkIngredients drinkIngredients = DrinkIngredients.builder()
                .drink(DrinkMapper.INSTANCE.toEntity(drinkService.getById(drinkId, 1)))
                .ingredient(IngredientMapper.INSTANCE.toEntity(ingredientService.getById(ingredientId)))
                .build();

        save(drinkIngredients);

        return DrinkIngredientsMapper.INSTANCE.toDto(drinkIngredients);
    }
}
