package com.example.ServiceMenuCoffee.repository;

import com.example.ServiceMenuCoffee.model.dto.DrinkTypeDto;
import com.example.ServiceMenuCoffee.model.entity.DrinkType;
import com.example.ServiceMenuCoffee.repository.projection.DrinkTypeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DrinkTypeRepository extends JpaRepository<DrinkType, Long> {
    @Query(value = "SELECT * FROM tb_drink_type WHERE name like %:name%", nativeQuery = true )
    DrinkTypeResponse findByName1(String name);

    DrinkType findByName(@Param("name") String name);
}
