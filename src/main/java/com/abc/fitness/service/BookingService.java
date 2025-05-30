package com.abc.fitness.service;

import com.abc.fitness.model.Booking;
import com.abc.fitness.model.FitnessClass;
import com.abc.fitness.repositories.BookingRepository;
import com.abc.fitness.repositories.FitnessClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final FitnessClassRepository classRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, FitnessClassRepository classRepository) {
        this.bookingRepository = bookingRepository;
        this.classRepository = classRepository;
    }

    public Booking createBooking(Booking booking) {
        validateBooking(booking);
        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByMember(String memberName) {
        return bookingRepository.findByMemberName(memberName);
    }

    public List<Booking> getBookingsByDateRange(LocalDate startDate, LocalDate endDate) {
        return bookingRepository.findByDateRange(startDate, endDate);
    }

    public List<Booking> getBookingsByMemberAndDateRange(String memberName, LocalDate startDate, LocalDate endDate) {
        return bookingRepository.findByMemberAndDateRange(memberName, startDate, endDate);
    }

    private void validateBooking(Booking booking) {
        if (booking.getMemberName() == null || booking.getMemberName().trim().isEmpty()) {
            throw new IllegalArgumentException("Member name is required");
        }
        if (booking.getFitnessClass() == null) {
            throw new IllegalArgumentException("Fitness class is required");
        }
        if (booking.getParticipationDate() == null) {
            throw new IllegalArgumentException("Participation date is required");
        }
        if (booking.getParticipationDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Participation date must be in the future");
        }

        // Check if the class exists
        List<FitnessClass> classes = classRepository.findByName(booking.getFitnessClass().getName());
        if (classes.isEmpty()) {
            throw new IllegalArgumentException("Fitness class does not exist");
        }

        // Check if the participation date is within the class schedule
        FitnessClass fitnessClass = classes.get(0);
        if (booking.getParticipationDate().isBefore(fitnessClass.getStartDate()) ||
            booking.getParticipationDate().isAfter(fitnessClass.getEndDate())) {
            throw new IllegalArgumentException("Participation date is outside of class schedule");
        }

        // Check capacity
        int currentBookings = bookingRepository.countBookingsForClassAndDate(fitnessClass, booking.getParticipationDate());
        if (currentBookings >= fitnessClass.getCapacity()) {
            throw new IllegalArgumentException("Class is at full capacity for this date");
        }
    }
}
