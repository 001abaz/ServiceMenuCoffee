package com.example.ServiceMenuCoffee.model.entity;

import com.example.ServiceMenuCoffee.model.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="tb_drink_type")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DrinkType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "create_date")
    LocalDateTime createdDate;
    @Column(name = "update_date")
    LocalDateTime updatedDate;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    Status status;
    @Column(name = "name")
    String name;
}
