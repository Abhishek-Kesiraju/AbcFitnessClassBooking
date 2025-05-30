package com.abc.fitness.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Long bookingId;

    private String memberName;

    private LocalDate participationDate;

    @ManyToOne
    private ClassEntity classEntity;
}
