package com.example.ServiceMenuCoffee.repository;

import com.example.ServiceMenuCoffee.model.entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
}
