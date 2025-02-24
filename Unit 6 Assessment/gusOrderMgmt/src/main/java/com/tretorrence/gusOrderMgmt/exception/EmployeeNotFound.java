package com.tretorrence.gusOrderMgmt.exception;

public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound(Long employeeId) {
        super("Employee not found with id " + employeeId);
    }
    
}
