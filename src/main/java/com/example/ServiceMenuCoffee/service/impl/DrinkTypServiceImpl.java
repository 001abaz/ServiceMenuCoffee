package com.example.ServiceMenuCoffee.service.impl;

import com.example.ServiceMenuCoffee.model.dto.DrinkDto;
import com.example.ServiceMenuCoffee.model.dto.DrinkTypeDto;
import com.example.ServiceMenuCoffee.model.entity.DrinkType;
import com.example.ServiceMenuCoffee.model.enums.Status;
import com.example.ServiceMenuCoffee.model.mapper.DrinkMapper;
import com.example.ServiceMenuCoffee.model.mapper.DrinkTypeMapper;
import com.example.ServiceMenuCoffee.model.request.CreateDrinkTypeRequest;
import com.example.ServiceMenuCoffee.repository.DrinkRepository;
import com.example.ServiceMenuCoffee.repository.DrinkTypeRepository;
import com.example.ServiceMenuCoffee.repository.projection.DrinkTypeResponse;
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
    public DrinkTypeDto save(DrinkType entity) {
        return DrinkTypeMapper.INSTANCE.toDto(repository.save(entity));
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
        DrinkType entity = DrinkType.builder()
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .status(Status.ACTIVE)
                .name(request.getName())
                .build();

        return save(entity);
    }

    @Override
    public DrinkTypeDto getByName(String name) {

//        DrinkTypeResponse response = repository.findByName1(name);
//        DrinkType drinkType = DrinkType.builder()
//                .id(response.getId())
//                .name(response.getName())
//                .createdDate(response.getCreatedDate())
//                .updatedDate(response.getUpdatedDate())
//                .status(response.getStatus())
//                .build();
        return DrinkTypeMapper.INSTANCE.toDto(repository.findByName(name));
    }
}
