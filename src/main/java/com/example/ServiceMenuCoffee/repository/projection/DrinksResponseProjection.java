package com.example.ServiceMenuCoffee.repository.projection;

public interface DrinksResponseProjection {
    Long getId();
    String getName();
    int getSize();
    int getPrice();
    String getDrinkType();
}
