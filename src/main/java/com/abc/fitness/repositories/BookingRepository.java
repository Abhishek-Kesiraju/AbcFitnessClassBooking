package com.abc.fitness.repositories;

import com.abc.fitness.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByMemberName(String memberName);
    List<Booking> findByParticipationDateBetween(LocalDate start, LocalDate end);
    List<Booking> findByMemberNameAndParticipationDateBetween(String memberName, LocalDate start, LocalDate end);
}
