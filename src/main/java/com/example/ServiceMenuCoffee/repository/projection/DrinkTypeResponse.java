package com.example.ServiceMenuCoffee.repository.projection;

import com.example.ServiceMenuCoffee.model.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public interface DrinkTypeResponse {
    Long getId();
    LocalDateTime getCreatedDate();
    LocalDateTime getUpdatedDate();
    Status getStatus();
    String getName();
}
