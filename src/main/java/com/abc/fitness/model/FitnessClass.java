package com.abc.fitness.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
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


    public FitnessClass(String name, LocalDate startDate, LocalDate endDate, LocalTime startTime, int durationMinutes, int capacity) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;
        this.capacity = capacity;
    }

    public FitnessClass() {

    }

    private void validateClass(FitnessClass fitnessClass) {
        if (fitnessClass.getName() == null || fitnessClass.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Class name is required");
        }
        if (fitnessClass.getStartDate() == null) {
            throw new IllegalArgumentException("Start date is required");
        }
        if (fitnessClass.getEndDate() == null) {
            throw new IllegalArgumentException("End date is required");
        }
        if (fitnessClass.getStartTime() == null) {
            throw new IllegalArgumentException("Start time is required");
        }
        if (fitnessClass.getDurationMinutes() <= 0) {
            throw new IllegalArgumentException("Duration must be greater than 0");
        }
        if (fitnessClass.getCapacity() < 1) {
            throw new IllegalArgumentException("Capacity must be at least 1");
        }
        if (fitnessClass.getEndDate().isBefore(fitnessClass.getStartDate())) {
            throw new IllegalArgumentException("End date must be after start date");
        }
        if (fitnessClass.getEndDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("End date must be in the future");
        }
    }
}