package com.abc.fitness.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class FitnessClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fitnessClassId;
    private String name;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    
    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;
    
    private int durationMinutes;
    private int capacity;

    public FitnessClass() {
    }

    public FitnessClass(String name, LocalDate startDate, LocalDate endDate, LocalTime startTime, int durationMinutes, int capacity) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;
        this.capacity = capacity;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
} 