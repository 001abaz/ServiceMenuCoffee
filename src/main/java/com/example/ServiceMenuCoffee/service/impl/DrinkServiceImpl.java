package com.example.ServiceMenuCoffee.service.impl;

import com.example.ServiceMenuCoffee.exception.NotFoundException;
import com.example.ServiceMenuCoffee.model.dto.DrinkDto;
import com.example.ServiceMenuCoffee.model.dto.DrinkTypeDto;
import com.example.ServiceMenuCoffee.model.entity.Drink;
import com.example.ServiceMenuCoffee.model.entity.DrinkType;
import com.example.ServiceMenuCoffee.model.enums.Status;
import com.example.ServiceMenuCoffee.model.mapper.DrinkMapper;
import com.example.ServiceMenuCoffee.model.mapper.DrinkTypeMapper;
import com.example.ServiceMenuCoffee.model.request.CreateDrinkRequest;
import com.example.ServiceMenuCoffee.repository.DrinkRepository;
import com.example.ServiceMenuCoffee.repository.DrinkTypeRepository;
import com.example.ServiceMenuCoffee.repository.projection.DrinksResponseProjection;
import com.example.ServiceMenuCoffee.service.DrinkService;
import com.example.ServiceMenuCoffee.service.DrinkTypeService;
import com.example.ServiceMenuCoffee.utils.Language;
import com.example.ServiceMenuCoffee.utils.ResourceBundleLanguage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DrinkServiceImpl implements DrinkService {
    private final DrinkRepository repository;
    private final DrinkTypeService drinkTypeService;
    @Override
    public DrinkDto save(Drink entity) {
        return DrinkMapper.INSTANCE.toDto(repository.save(entity));
    }

    @Override
    public DrinkDto getById(Long id, int languageOrdinal) {
        Language language = Language.getLanguage(languageOrdinal);
        Drink entity = repository.findById(id).orElseThrow(()
                -> new NotFoundException(ResourceBundleLanguage.periodMessage(language, "entityNotFound")));
        DrinkDto dto = DrinkDto.builder()
                .id(entity.getId())
                .price(entity.getPrice())
                .drinkTypeDto(DrinkTypeMapper.INSTANCE.toDto( entity.getDrinkType()))
                .size(entity.getSize())
                .createdDate(entity.getCreatedDate())
                .updatedDate(entity.getUpdatedDate())
                .name(entity.getName())
                .status(entity.getStatus())
                .build();
        return dto;
    }

    @Override
    public List<DrinkDto> getAll() {
        List<Drink> drinks = repository.findAll(); // Fetch drinks from the repository
        List<DrinkDto> drinkDtos = new ArrayList<>();

        for (Drink drink : drinks) {
            DrinkDto drinkDto = new DrinkDto();
            drinkDto.setId(drink.getId());
            drinkDto.setCreatedDate(drink.getCreatedDate());
            drinkDto.setUpdatedDate(drink.getUpdatedDate());
            drinkDto.setStatus(drink.getStatus());
            drinkDto.setName(drink.getName());
            drinkDto.setPrice(drink.getPrice());
            drinkDto.setSize(drink.getSize());

            // Convert DrinkType to DrinkTypeDto before setting it
            DrinkType drinkType = drink.getDrinkType();
            DrinkTypeDto drinkTypeDto = DrinkTypeMapper.INSTANCE.toDto(drinkType);
            drinkDto.setDrinkTypeDto(drinkTypeDto);

            drinkDtos.add(drinkDto);
        }

        return drinkDtos;
    }


    @Override
    public DrinkDto create(CreateDrinkRequest request) {

        Drink entity = Drink.builder()
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .status(Status.ACTIVE)
                .name(request.getName())
                .drinkType(DrinkTypeMapper.INSTANCE.toEntity(drinkTypeService.getByName(request.getDrinkTypeName())))
                .price(request.getPrice())
                .size(request.getSize())
                .build();

        return save(entity);
    }



    @Override
    public List<DrinksResponseProjection> findAllByPriceAfterAndPriceBeforeAAndDrinkType(String drinkType, double priceFrom, double priceTo) {
        DrinkType drinkType1 = new DrinkType();


        if (drinkType == null && priceTo != 0 && priceFrom !=0){
            return repository.findAllByPriceAfterAndPriceBefore(priceFrom, priceTo);
        } else if (priceTo == 0 && priceFrom != 0 && drinkType != null) {
            return repository.findAllByPriceAfterAndDrinkType(drinkType, priceFrom);
        } else if (priceFrom == 0 && priceTo != 0 && drinkType != null) {
            return repository.findAllByPriceBeforeAndDrinkType(drinkType, priceTo);
        } else if (drinkType == null && priceTo == 0 && priceFrom != 0) {
            return repository.findAllByPriceAfter(priceFrom);
        } else if (drinkType == null && priceFrom == 0 && priceTo != 0) {
            return repository.findAllByPriceBefore(priceTo);
        } else if (priceTo == 0 && priceFrom == 0 && drinkType != null) {
            return repository.findAllByDrinkType(drinkType);
        } else if (drinkType == null && priceTo  == 0 && priceFrom == 0) {
            return repository.findAllNull();
        }else {
            return repository.findAllByPriceAfterAndPriceBeforeAndDrinkType(drinkType, priceFrom, priceTo);
        }
    }

    @Override
    public List<DrinksResponseProjection> findAllByName(String name) {
        return repository.findAllByDrinkName(name);
    }

    @Override
    public List<DrinksResponseProjection> findAllByDrinkTypeName(String name) {
        return repository.findAllByDrinkTypeName(name);
    }


}
