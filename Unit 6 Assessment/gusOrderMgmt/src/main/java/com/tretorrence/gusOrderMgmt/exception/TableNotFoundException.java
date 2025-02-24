package com.tretorrence.gusOrderMgmt.exception;

public class TableNotFoundException extends RuntimeException{
    public TableNotFoundException(Long tableId) {
        super("Table not found with id " + tableId);
    }
}
