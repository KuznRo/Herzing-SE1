package com.tretorrence.gusOrderMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tretorrence.gusOrderMgmt.model.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
    
}
