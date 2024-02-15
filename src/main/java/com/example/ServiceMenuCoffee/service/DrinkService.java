package com.example.ServiceMenuCoffee.service;

import com.example.ServiceMenuCoffee.model.dto.DrinkDto;
import com.example.ServiceMenuCoffee.model.entity.Drink;
import com.example.ServiceMenuCoffee.model.request.CreateDrinkRequest;
import com.example.ServiceMenuCoffee.model.request.CreateDrinkTypeRequest;
import com.example.ServiceMenuCoffee.repository.projection.DrinksResponseProjection;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DrinkService {
    DrinkDto save(Drink entity);

    DrinkDto getById(Long id , int languageOrdinal);

    List<DrinkDto> getAll();

    DrinkDto create(CreateDrinkRequest request);
    List<DrinksResponseProjection> findAllByPriceAfterAndPriceBeforeAAndDrinkType(String drinkType, double priceFrom, double priceTo);

    List<DrinksResponseProjection> findAllByName(String name);
    List<DrinksResponseProjection> findAllByDrinkTypeName(String name);


}