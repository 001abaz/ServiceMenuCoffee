package com.example.ServiceMenuCoffee.model.request;

import com.example.ServiceMenuCoffee.model.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateIngredientRequest {
    String name;
}
