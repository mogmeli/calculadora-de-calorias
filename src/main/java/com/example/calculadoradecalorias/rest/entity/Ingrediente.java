package com.example.calculadoradecalorias.rest.entity;

public class Ingrediente {

    public String name;
    public int calories;

    public Ingrediente(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }
}