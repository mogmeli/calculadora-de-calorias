package com.example.calculadoradecalorias.rest.dao;

import com.example.calculadoradecalorias.rest.entity.Ingrediente;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodRepository {
    private static final File FILE = new File("food.json");


    @Autowired
    ObjectMapper mapper;

    public List<Ingrediente> getList(){
        List<Ingrediente> food = new ArrayList<>();

            try{
                FileInputStream is = new FileInputStream(FILE);
                TypeReference<List<Ingrediente>> typeReference = new TypeReference<List<Ingrediente>>() {};
                food = mapper.readValue(is, typeReference);
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return food;
        }
    public Ingrediente get(int index){

        List<Ingrediente> food = new ArrayList<>();

        try{
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Ingrediente>> typeReference = new TypeReference<List<Ingrediente>>() {};
            food = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return food.get(index);

    }

    public void add(Ingrediente ingrediente){
        try{
            List<Ingrediente> food = getList();
            food.add(ingrediente);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, food);
            out.close();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}