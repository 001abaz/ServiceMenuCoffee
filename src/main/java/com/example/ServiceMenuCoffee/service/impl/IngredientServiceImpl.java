package com.example.ServiceMenuCoffee.service.impl;

import com.example.ServiceMenuCoffee.model.dto.DrinkDto;
import com.example.ServiceMenuCoffee.model.dto.IngredientDto;
import com.example.ServiceMenuCoffee.model.enums.Status;
import com.example.ServiceMenuCoffee.model.mapper.DrinkMapper;
import com.example.ServiceMenuCoffee.model.mapper.IngredientMapper;
import com.example.ServiceMenuCoffee.model.request.CreateIngredientRequest;
import com.example.ServiceMenuCoffee.repository.IngredientRepository;
import com.example.ServiceMenuCoffee.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository repository;


    @Override
    public IngredientDto save(IngredientDto dto) {
        return IngredientMapper.INSTANCE.toDto(repository.save(IngredientMapper.INSTANCE.toEntity(dto)));
    }

    @Override
    public IngredientDto getById(Long id) {
        return IngredientMapper.INSTANCE.toDto(repository.findById(id).orElseThrow());
    }

    @Override
    public List<IngredientDto> getAll() {
        return IngredientMapper.INSTANCE.toDtos(repository.findAll());
    }

    @Override
    public IngredientDto create(CreateIngredientRequest request) {
        IngredientDto dto = new IngredientDto();

        dto.setCreatedDate(LocalDateTime.now());
        dto.setUpdatedDate(LocalDateTime.now());
        dto.setStatus(Status.ACTIVE);
        dto.setName(request.getName());

        return save(dto);
    }

}
