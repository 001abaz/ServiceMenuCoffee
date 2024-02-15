package com.example.ServiceMenuCoffee.repository;

import com.example.ServiceMenuCoffee.model.entity.Drink;
import com.example.ServiceMenuCoffee.model.entity.DrinkType;
import com.example.ServiceMenuCoffee.repository.projection.DrinksResponseProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {

//    List<Drink> findAllByPriceBetween();
    @Query(value = "select d.id as id, d.name as Name, d.size as Size,  d.price as Price, dt.name as drinkType from tb_drink d " +
            "inner join tb_drink_type dt ON drink_type_id = dt.id " +
            "where price between :price1 and :price2", nativeQuery = true )
    List<DrinksResponseProjection> findAllByPriceAfterAndPriceBefore( double price1, double price2);
    @Query(value = "select d.id as id, d.name as Name, d.size as Size,  d.price as Price, dt.name as drinkType from tb_drink d " +
            "inner join tb_drink_type dt ON drink_type_id = dt.id "
            , nativeQuery = true )
    List<DrinksResponseProjection> findAllNull();

    @Query(value = "select d.id as id, d.name as Name, d.size as Size,  d.price as Price, dt.name as drinkType from tb_drink d " +
            "inner join tb_drink_type dt ON drink_type_id = dt.id " +
            "where dt.name = :drinkType and price between :price1 and :price2", nativeQuery = true )
    List<DrinksResponseProjection> findAllByPriceAfterAndPriceBeforeAndDrinkType(@Param("drinkType") String drinkType, double price1, double price2);

    @Query(value = "select d.id as id, d.name as Name, d.size as Size,  d.price as Price, dt.name as drinkType from tb_drink d " +
            "inner join tb_drink_type dt ON drink_type_id = dt.id " +
            "where dt.name = :drinkType and price >= :price1", nativeQuery = true )
    List<DrinksResponseProjection> findAllByPriceAfterAndDrinkType(@Param("drinkType") String drinkType, double price1);

    @Query(value = "select d.id as id, d.name as Name, d.size as Size,  d.price as Price, dt.name as drinkType from tb_drink d " +
            "inner join tb_drink_type dt ON drink_type_id = dt.id " +
            "where dt.name = :drinkType and price <= :price1", nativeQuery = true )
    List<DrinksResponseProjection> findAllByPriceBeforeAndDrinkType(@Param("drinkType") String drinkType, double price1);
    @Query(value = "select d.id as id, d.name as Name, d.size as Size,  d.price as Price, dt.name as drinkType from tb_drink d " +
            "inner join tb_drink_type dt ON drink_type_id = dt.id " +
            "where dt.name = :drinkType", nativeQuery = true )
    List<DrinksResponseProjection> findAllByDrinkType(@Param("drinkType") String drinkType);

    @Query(value = "select d.id as id, d.name as Name, d.size as Size,  d.price as Price, dt.name as drinkType from tb_drink d " +
            "inner join tb_drink_type dt ON drink_type_id = dt.id " +
            "where d.price <= :price1", nativeQuery = true )
    List<DrinksResponseProjection> findAllByPriceBefore( double price1);

    @Query(value = "select d.id as id, d.name as Name, d.size as Size,  d.price as Price, dt.name as drinkType from tb_drink d " +
            "inner join tb_drink_type dt ON drink_type_id = dt.id " +
            "where d.price >= :price1", nativeQuery = true )
    List<DrinksResponseProjection> findAllByPriceAfter( double price1);


    @Query(value = "select d.id as id, d.name as Name, d.size as Size,  d.price as Price, dt.name as drinkType from tb_drink d " +
            "inner join tb_drink_type dt ON drink_type_id = dt.id " +
            "where d.name like %:name%", nativeQuery = true )
    List<DrinksResponseProjection> findAllByDrinkName(@Param("name") String name);

    @Query(value = "select d.id as id, d.name as Name, d.size as Size,  d.price as Price, dt.name as drinkType from tb_drink d " +
            "inner join tb_drink_type dt ON drink_type_id = dt.id " +
            "where dt.name like %:name%", nativeQuery = true )
    List<DrinksResponseProjection> findAllByDrinkTypeName(@Param("name") String name);





}
