package com.example.calculadoradecalorias.rest.controller;

import com.example.calculadoradecalorias.rest.entity.Ingrediente;
import com.example.calculadoradecalorias.rest.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping()
public class FoodController {

    @Autowired
    private FoodService foodService;


    @GetMapping("/all")
    public List<Ingrediente> getAll(){
        List<Ingrediente> food = foodService.listar();
        return food;
    }

    @PostMapping
    public ResponseEntity<Ingrediente> cadastra(@RequestBody Ingrediente ingrediente, UriComponentsBuilder uriBuilder){
        foodService.addIngrediente(ingrediente);
        URI uri = uriBuilder.path("/ingredient" +
                "/{id}").buildAndExpand(ingrediente.getName()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/single/{index}")
    public Ingrediente getSingle(@PathVariable int index){
        Ingrediente ingrediente = foodService.returnSingle(index);
        return ingrediente;
    }}