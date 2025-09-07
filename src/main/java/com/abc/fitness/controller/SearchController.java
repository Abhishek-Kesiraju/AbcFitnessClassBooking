package com.abc.fitness.controller;

import com.abc.fitness.model.Booking;
import com.abc.fitness.service.BookingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final BookingService bookingService;

    public SearchController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getBookingsByMemberAndDateRange(
            @RequestParam(name = "memberName",  required = false) String memberName,
            @RequestParam(name = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(name = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<Booking> bookings = bookingService.searchBookings(memberName, startDate, endDate);
        return ResponseEntity.ok(bookings);
    }
}
