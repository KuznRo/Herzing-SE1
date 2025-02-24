package com.tretorrence.gusOrderMgmt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class TableServices {

    @Id
    @GeneratedValue
    private Long tableId;
    private int tableNumber;
    private String tableStatus;
    private boolean reservedTable;
    private int numberOfSeats;
    private String reservationName;
    
    @CreationTimestamp
    private LocalDateTime reservationTime;
    private String assignedServer;


    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(String tableStatus) {
        this.tableStatus = tableStatus;
    }

    public boolean getReservedTable() {
        return reservedTable;
    }

    public void setReservedTable(boolean reservedTable) {
        this.reservedTable = reservedTable;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public String getAssignedServer() {
        return assignedServer;
    }

    public void setAssignedServer(String assignedServer) {
        this.assignedServer = assignedServer;
    }
}