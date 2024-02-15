package com.example.ServiceMenuCoffee.model.entity;

import com.example.ServiceMenuCoffee.model.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="tb_drink_ingredients")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DrinkIngredients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drink_id")
    Drink drink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    Ingredient ingredient;
}
