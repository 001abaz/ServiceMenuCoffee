package com.example.ServiceMenuCoffee.controrller;

import com.example.ServiceMenuCoffee.model.dto.DrinkDto;
import com.example.ServiceMenuCoffee.model.request.CreateDrinkRequest;
import com.example.ServiceMenuCoffee.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/drink")
public class DrinkController {
    private final DrinkService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateDrinkRequest request) {

        DrinkDto dto = service.create(request);
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
