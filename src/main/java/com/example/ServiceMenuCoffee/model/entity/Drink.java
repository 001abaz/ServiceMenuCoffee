package com.example.ServiceMenuCoffee.model.entity;

import com.example.ServiceMenuCoffee.model.dto.IngredientDto;
import com.example.ServiceMenuCoffee.model.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="tb_drink")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "create_date")
    LocalDateTime createdDate;
    @Column(name = "update_date")
    LocalDateTime updatedDate;
    @Enumerated(EnumType.STRING)
    Status status;

    @ManyToOne()
    @JoinColumn(name="drink_type_id", referencedColumnName = "id")
    DrinkType drinkType;
    @Column(name = "name")
    String name;
    int price;
    int size;

}
