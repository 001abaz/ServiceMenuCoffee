package com.example.ServiceMenuCoffee.controrller;

import com.example.ServiceMenuCoffee.model.dto.DrinkDto;
import com.example.ServiceMenuCoffee.model.dto.DrinkTypeDto;
import com.example.ServiceMenuCoffee.model.entity.DrinkIngredients;
import com.example.ServiceMenuCoffee.model.request.CreateDrinkRequest;
import com.example.ServiceMenuCoffee.service.DrinkIngredientsService;
import com.example.ServiceMenuCoffee.service.DrinkService;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v2/drink-controller")
public class DrinkController {
    private final DrinkService service;
    private final DrinkIngredientsService drinkIngredientsService;



    @PostMapping("/save")
    public ResponseEntity<?> create(@RequestBody CreateDrinkRequest request) {
        DrinkDto dto = service.create(request);
        return ResponseEntity.ok().body(dto);
    }
    @GetMapping("/getById")
    public ResponseEntity<?> getById(Long id, int languageOrdinal){
        return ResponseEntity.ok(service.getById(id, languageOrdinal));
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }



    @PostMapping("/addIngredients")
    public ResponseEntity<Void> addIngredientToDrink(@PathVariable Long drinkId, @PathVariable Long  ingredientId) {
        drinkIngredientsService.create(drinkId, ingredientId);
        return ResponseEntity.ok().build();
    }
}
