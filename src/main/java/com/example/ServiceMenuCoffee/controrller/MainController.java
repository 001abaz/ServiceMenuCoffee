package com.example.ServiceMenuCoffee.controrller;

import com.example.ServiceMenuCoffee.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/drink")
public class MainController {

    private final DrinkService service;


    @GetMapping("/drink")
    public ResponseEntity<?> getAllByPriceAndDrinkType(@Nullable String drinkType, @Nullable int priceFrom, @Nullable int priceTo){
        return ResponseEntity.ok(service.findAllByPriceAfterAndPriceBeforeAAndDrinkType(drinkType,  priceFrom, priceTo));
    }

    @GetMapping("/name")
    public ResponseEntity<?> getAllDrinkName(String name){
        return ResponseEntity.ok(service.findAllByName(name));
    }

    @GetMapping("/type")
    public ResponseEntity<?> getAllByDrinkType(String name){
        return ResponseEntity.ok(service.findAllByDrinkTypeName(name));
    }
}
