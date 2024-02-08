package com.example.ServiceMenuCoffee.service.impl;

import com.example.ServiceMenuCoffee.model.dto.DrinkDto;
import com.example.ServiceMenuCoffee.model.enums.Status;
import com.example.ServiceMenuCoffee.model.mapper.DrinkMapper;
import com.example.ServiceMenuCoffee.model.request.CreateDrinkRequest;
import com.example.ServiceMenuCoffee.repository.DrinkRepository;
import com.example.ServiceMenuCoffee.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DrinkServiceImpl implements DrinkService {
    private final DrinkRepository repository;
    @Override
    public DrinkDto save(DrinkDto dto) {
        return DrinkMapper.INSTANCE.toDto(repository.save(DrinkMapper.INSTANCE.toEntity(dto)));
    }

    @Override
    public DrinkDto getById(Long id) {
        return DrinkMapper.INSTANCE.toDto(repository.findById(id).orElseThrow());
    }

    @Override
    public List<DrinkDto> getAll() {
        return DrinkMapper.INSTANCE.toDtos(repository.findAll());
    }

    @Override
    public DrinkDto create(CreateDrinkRequest request) {
        DrinkDto dto = new DrinkDto();

        dto.setCreatedDate(LocalDateTime.now());
        dto.setUpdatedDate(LocalDateTime.now());

        dto.setStatus(Status.ACTIVE);
        dto.setName(request.getName());
        dto.setDrinkType(request.getDrinkType());
        dto.setIngredient(request.getIngredient());
        dto.setPrice(request.getPrice());
        dto.setSize(request.getSize());

        return save(dto);
    }
}
