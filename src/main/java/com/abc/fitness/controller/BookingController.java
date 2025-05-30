package com.abc.fitness.controller;

import com.abc.fitness.model.Booking;
import com.abc.fitness.model.ClassEntity;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

        @PostMapping
        public ResponseEntity<?>  bookClass(@RequestBody Booking booking){
            //Call bookClass Service

            return null;
        }

        @GetMapping("/search")
        public ResponseEntity<List<Booking>> searchBookings( @RequestParam(required = false)
                                                                     String member,
                                                             @RequestParam(required = false)
                                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                     LocalDate startDate,
                                                             @RequestParam(required = false)
                                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                     LocalDate endDate
        ){
            //Call Search Booking Service
            return null;
        }

}
