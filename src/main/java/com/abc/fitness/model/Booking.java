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

    // Getters and Setters
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public FitnessClass getFitnessClass() {
        return fitnessClass;
    }

    public void setFitnessClass(FitnessClass fitnessClass) {
        this.fitnessClass = fitnessClass;
    }

    public LocalDate getParticipationDate() {
        return participationDate;
    }

    public void setParticipationDate(LocalDate participationDate) {
        this.participationDate = participationDate;
    }
}
