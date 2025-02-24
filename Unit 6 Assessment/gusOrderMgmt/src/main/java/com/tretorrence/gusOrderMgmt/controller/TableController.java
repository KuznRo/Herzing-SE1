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
import com.tretorrence.gusOrderMgmt.model.TableServices;
import com.tretorrence.gusOrderMgmt.repository.TableRepository;

@RestController
@RequestMapping("/")
public class TableController {
    
    @Autowired
    private TableRepository tableRepository;

   
    @PostMapping("/table")
    TableServices newTable(@RequestBody TableServices newTable) {
        return tableRepository.save(newTable);
    }

    
    @GetMapping("/tables")
    List<TableServices> getAllTables() {
        return tableRepository.findAll();
    }
    
    @GetMapping("/tables/{tableId}")
    TableServices getTablebyId(@PathVariable Long tableId) {
        return tableRepository.findById(tableId)
            .orElseThrow(null);
    }
    
    @PutMapping("/table/{tableId}")
    TableServices updateTable(@RequestBody TableServices newTable, @PathVariable Long tableId) {
        return tableRepository.findById(tableId)
            .map(table -> {
                table.setTableNumber(newTable.getTableNumber());
                table.setTableStatus(newTable.getTableStatus());
                table.setReservedTable(newTable.getReservedTable());
                table.setNumberOfSeats(newTable.getNumberOfSeats());
                table.setReservationName(newTable.getReservationName());
                table.setReservationTime(newTable.getReservationTime());
                table.setAssignedServer(newTable.getAssignedServer());
                return tableRepository.save(table);
            }).orElseThrow(() -> new TableNotFoundException(tableId));
    }
   
    @DeleteMapping("/table/{tableId}")
    String deleteTable(@PathVariable Long tableId) {
        if(!tableRepository.existsById(tableId)) {
            throw new TableNotFoundException(tableId);
        }
        tableRepository.deleteById(tableId);
        return "Deleted Successfully";
    }
}
