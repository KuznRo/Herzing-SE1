package com.tretorrence.gusOrderMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tretorrence.gusOrderMgmt.model.FrontServices;

public interface FrontRepository extends JpaRepository<FrontServices, Long> {
    
}
