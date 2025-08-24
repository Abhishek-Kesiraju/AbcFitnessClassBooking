package com.abc.fitness.service;

import com.abc.fitness.exception.ResourceNotFoundException;
import com.abc.fitness.model.Booking;
import com.abc.fitness.model.FitnessClass;
import com.abc.fitness.repositories.BookingRepository;
import com.abc.fitness.repositories.FitnessClassRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcConnectionDetails;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class BookingService {


    private final BookingRepository bookingRepository;

    private final FitnessClassRepository fitnessClassRepository;

    public BookingService(BookingRepository bookingRepository, FitnessClassRepository fitnessClassRepository) {
            this.bookingRepository = bookingRepository;
            this.fitnessClassRepository = fitnessClassRepository;
    }

    @Transactional
    public Booking createBooking(Booking booking) {

        validateBooking(booking); // check if a fitness class is present to book it
        bookingRepository.save(booking);

     return booking;
    }

    private void validateBooking(Booking booking) {

        Long fitnessClassId   = booking.getFitnessClass().getFitnessClassId();

            boolean exists = fitnessClassRepository.existsById(fitnessClassId);
            if (!exists) {
                throw new ResourceNotFoundException("Fitness class not found");
            }
    }

    public List<Booking> searchBookings(String memberName, LocalDate startDate, LocalDate endDate) {
        // If all three members are present
        if(memberName != null && startDate != null && endDate != null) {
            return bookingRepository.findByMemberNameAndParticipationDateBetween(memberName, startDate, endDate);
        }

        // If only memberName is present
        if(memberName != null && startDate == null && endDate == null) {
            return bookingRepository.findByMemberName(memberName);
        }

        // If only daterange is present
        if(memberName == null && startDate != null && endDate != null){
            return bookingRepository.findByParticipationDateBetween(startDate, endDate);
        }
        //None present
        return bookingRepository.findAll();
    }
}


