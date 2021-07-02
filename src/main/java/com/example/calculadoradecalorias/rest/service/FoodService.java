package com.example.calculadoradecalorias.rest.service;

import com.example.calculadoradecalorias.rest.dao.FoodRepository;
import com.example.calculadoradecalorias.rest.entity.Ingrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository repository;

    public void addIngrediente(Ingrediente ingrediente){
        if(ingrediente.getCalories() < 0){
            throw new RuntimeException("CALORIA must be bigger than 0");
        }
        repository.add(ingrediente);
    }

    public Ingrediente returnSingle(int index){
        return repository.get(index);
    }

    public List<Ingrediente> listar(){
        return repository.getList();
    }
}