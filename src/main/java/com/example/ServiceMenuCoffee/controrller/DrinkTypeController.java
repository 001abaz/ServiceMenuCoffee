package com.example.ServiceMenuCoffee.controrller;

import com.example.ServiceMenuCoffee.model.dto.DrinkTypeDto;
import com.example.ServiceMenuCoffee.model.request.CreateDrinkTypeRequest;
import com.example.ServiceMenuCoffee.service.DrinkTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/drinkType")
public class DrinkTypeController {
    private final DrinkTypeService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateDrinkTypeRequest request) {

        DrinkTypeDto dto = service.create(request);
        return ResponseEntity.ok().body(dto);
    }
    @GetMapping("/getById")
    public ResponseEntity<?> getById(Long id){
        return ResponseEntity.ok(service.getById(id));
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
}
