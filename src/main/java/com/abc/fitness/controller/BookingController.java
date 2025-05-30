package com.abc.fitness.controller;

import com.abc.fitness.model.Booking;
import com.abc.fitness.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        try {
            Booking createdBooking = bookingService.createBooking(booking);
            return ResponseEntity.ok(createdBooking);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/member/{memberName}")
    public ResponseEntity<List<Booking>> getBookingsByMember(@PathVariable String memberName) {
        return ResponseEntity.ok(bookingService.getBookingsByMember(memberName));
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<Booking>> getBookingsByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(bookingService.getBookingsByDateRange(startDate, endDate));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Booking>> getBookingsByMemberAndDateRange(
            @RequestParam String memberName,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(bookingService.getBookingsByMemberAndDateRange(memberName, startDate, endDate));
    }
    
	/*
	 * @GetMapping("/search") public ResponseEntity<List<Booking>> getBookings(
	 * ResponseEntity<List<Booking>> getBooking() {
	 * 
	 * }
	 * 
	 * @RequestParam String memberName,
	 * 
	 * @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate
	 * startDate,
	 * 
	 * @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate
	 * endDate) { return
	 * ResponseEntity.ok(bookingService.getBookingsByMemberAndDateRange(memberName,
	 * startDate, endDate)); }
	 */
}
