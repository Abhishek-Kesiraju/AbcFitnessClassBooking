package com.abc.fitness.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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

}