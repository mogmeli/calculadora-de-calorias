package com.example.calculadoradecalorias.rest.entity;

import java.util.List;

public class Food {
    public List<Ingrediente> ingredienteList;

    public List<Ingrediente> getIngredienteList() {
        return ingredienteList;
    }

    public Food(List<Ingrediente> list){
        this.ingredienteList = list;
    }

}