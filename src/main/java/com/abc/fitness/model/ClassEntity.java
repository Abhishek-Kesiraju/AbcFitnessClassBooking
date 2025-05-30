package com.abc.fitness.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class ClassEntity {

    @Id
    @GeneratedValue
    private Long classId;

    private String Name;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalTime startTime;

    private int duration;

    private int capacity;

}
