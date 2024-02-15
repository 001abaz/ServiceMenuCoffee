package com.example.ServiceMenuCoffee.controrller;

import com.example.ServiceMenuCoffee.model.dto.DrinkDto;
import com.example.ServiceMenuCoffee.model.dto.IngredientDto;
import com.example.ServiceMenuCoffee.model.request.CreateDrinkRequest;
import com.example.ServiceMenuCoffee.model.request.CreateIngredientRequest;
import com.example.ServiceMenuCoffee.service.DrinkService;
import com.example.ServiceMenuCoffee.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v2/ingredient")
public class IngredientController {
    private final IngredientService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateIngredientRequest request) {

        IngredientDto dto = service.create(request);
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
