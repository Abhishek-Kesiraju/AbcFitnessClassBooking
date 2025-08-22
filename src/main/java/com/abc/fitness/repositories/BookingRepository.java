package com.abc.fitness.repositories;

import com.abc.fitness.model.Booking;
import com.abc.fitness.model.FitnessClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByMemberName (String memberName);

    List<Booking> findByParticipationDateBetween(LocalDate startDate, LocalDate endDate);

    List<Booking> findByMemberNameAndParticipationDateBetween(
            String memberName,
            LocalDate startDate,
            LocalDate endDate
    );

}
