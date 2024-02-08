package com.example.ServiceMenuCoffee.model.entity;

import com.example.ServiceMenuCoffee.model.enums.Status;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_ingredient")

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "create_date")
    LocalDateTime createdDate;
    @Column(name = "update_date")
    LocalDateTime updatedDate;
    @Enumerated(EnumType.STRING)
    Status status;
    @Column(name = "name")
    String name;
}
