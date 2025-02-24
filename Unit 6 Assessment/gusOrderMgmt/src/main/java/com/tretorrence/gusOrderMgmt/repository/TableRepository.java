package com.tretorrence.gusOrderMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tretorrence.gusOrderMgmt.model.TableServices;

public interface TableRepository extends JpaRepository<TableServices, Long> {
    
}
