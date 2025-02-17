package com.tretorrence.gusOrderMgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tretorrence.gusOrderMgmt.repository.FoodRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tretorrence.gusOrderMgmt.exception.FoodNotFoundException;
import com.tretorrence.gusOrderMgmt.model.Food;

@RestController
@RequestMapping("/")
public class FoodController {
    
    @Autowired
    private FoodRepository foodRepository;

    @PostMapping("/food")
    Food newFood(@RequestBody Food newFood) {
        return foodRepository.save(newFood);
    }
    
    @GetMapping("/foods")
    List<Food> getAllFoods() {
        return foodRepository.findAll();
    }
    
    @GetMapping("/foods/{id}")
    Food getFoodbyId(@PathVariable Long id) {
        return foodRepository.findById(id)
            .orElseThrow(null);
    }
    
    @PutMapping("/food/{id}")
    Food updateFood(@RequestBody Food newFood, @PathVariable Long id) {
        return foodRepository.findById(id)
            .map(food -> {
                food.setName(newFood.getName());
                food.setPrice(newFood.getPrice());
                food.setDescription(newFood.getDescription());
                food.setCreatedAt(newFood.getCreatedAt());
                return foodRepository.save(food);
            }).orElseThrow(() -> new FoodNotFoundException(id));
    }

    @DeleteMapping("/food/{id}")
    String deleteFood(@PathVariable Long id) {
        if(!foodRepository.existsById(id)) {
            throw new FoodNotFoundException(id);
        }
        foodRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
