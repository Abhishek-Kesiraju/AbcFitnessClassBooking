package com.abc.fitness.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue
    private Long Bookingid;
    private String memberName;

    @ManyToOne
    private FitnessClass fitnessClass;
    private LocalDate participationDate;

    public Booking() {
    }

    public Booking(String memberName, FitnessClass fitnessClass, LocalDate participationDate) {
        this.memberName = memberName;
        this.fitnessClass = fitnessClass;
        this.participationDate = participationDate;
    }
}
