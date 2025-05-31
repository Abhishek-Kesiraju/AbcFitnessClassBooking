package com.abc.fitness.service;

import com.abc.fitness.model.Booking;
import com.abc.fitness.model.FitnessClass;
import com.abc.fitness.repositories.BookingRepository;
import com.abc.fitness.repositories.FitnessClassRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {

    private  BookingRepository bookingRepository;
    private  FitnessClassRepository classRepository;

    public BookingService(BookingRepository bookingRepository){
            this.bookingRepository = bookingRepository;
    }

    @Transactional
    public Booking createBooking(Booking booking) {

        //Add code to fetch FitnessClass from DB using ID
        // ELSE through exception
        //Then set the booking's fitness class booking.setFitnessClass(fitnessclass);
     bookingRepository.save(booking);

     return booking;
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


