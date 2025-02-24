package com.tretorrence.gusOrderMgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tretorrence.gusOrderMgmt.exception.TableNotFoundException;
import com.tretorrence.gusOrderMgmt.model.FrontServices;
import com.tretorrence.gusOrderMgmt.repository.FrontRepository;

@RestController
@RequestMapping("/")
public class FrontController {
    
    @Autowired
    private FrontRepository frontRepository;

    @PostMapping("/employee")
    FrontServices newEmployee(@RequestBody FrontServices newEmployee) {
        return frontRepository.save(newEmployee);
    }
    
    
    @GetMapping("/employees")
    List<FrontServices> getAllEmployees() {
        return frontRepository.findAll();
    }
    
    @GetMapping("/employees/{employeeId}")
    FrontServices getEmployeeById(@PathVariable Long employeeId) {
        return frontRepository.findById(employeeId)
            .orElseThrow(null);
    }
    
    @PutMapping("/employee/{employeeId}")
    FrontServices updateEmployee(@RequestBody FrontServices newEmployee, @PathVariable Long employeeId) {
        return frontRepository.findById(employeeId)
            .map(employee -> {
                employee.setEmployeeName(newEmployee.getEmployeeName());
                employee.setEmployeeRole(newEmployee.getEmployeeRole());
                employee.setEmployeeStatus(newEmployee.getEmployeeStatus());
                return frontRepository.save(employee);
            }).orElseThrow(() -> new TableNotFoundException(employeeId));
    }
   
    
    @DeleteMapping("/employee/{employeeId}")
    String deleteEmployee(@PathVariable Long employeeId) {
        if(!frontRepository.existsById(employeeId)) {
            throw new TableNotFoundException(employeeId);
        }
        frontRepository.deleteById(employeeId);
        return "Deleted Successfully";
    }
}
