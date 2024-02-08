package com.example.ServiceMenuCoffee.service.impl;

import com.example.ServiceMenuCoffee.model.dto.DrinkDto;
import com.example.ServiceMenuCoffee.model.dto.DrinkTypeDto;
import com.example.ServiceMenuCoffee.model.enums.Status;
import com.example.ServiceMenuCoffee.model.mapper.DrinkMapper;
import com.example.ServiceMenuCoffee.model.mapper.DrinkTypeMapper;
import com.example.ServiceMenuCoffee.model.request.CreateDrinkTypeRequest;
import com.example.ServiceMenuCoffee.repository.DrinkRepository;
import com.example.ServiceMenuCoffee.repository.DrinkTypeRepository;
import com.example.ServiceMenuCoffee.service.DrinkTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DrinkTypServiceImpl implements DrinkTypeService {
    private final DrinkTypeRepository repository;

    @Override
    public DrinkTypeDto save(DrinkTypeDto dto) {
        return DrinkTypeMapper.INSTANCE.toDto(repository.save(DrinkTypeMapper.INSTANCE.toEntity(dto)));
    }

    @Override
    public DrinkTypeDto getById(Long id) {
        return DrinkTypeMapper.INSTANCE.toDto(repository.findById(id).orElseThrow());
    }

    @Override
    public List<DrinkTypeDto> getAll() {
        return DrinkTypeMapper.INSTANCE.toDtos(repository.findAll());
    }

    @Override
    public DrinkTypeDto create(CreateDrinkTypeRequest request){
        DrinkTypeDto dto = new DrinkTypeDto();
        dto.setCreatedDate(LocalDateTime.now());
        dto.setUpdatedDate(LocalDateTime.now());
        dto.setStatus(Status.ACTIVE);
        dto.setName(request.getName());

        return save(dto);
    }
}
