package com.abc.fitness.controller;

import com.abc.fitness.model.FitnessClass;
import com.abc.fitness.repositories.FitnessClassRepository;
import com.abc.fitness.service.FitnessClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/classes")
public class FitnessClassController {

    @Autowired
    public FitnessClassService fitnessClassService;


    @PostMapping
    public ResponseEntity<?> createClass(@RequestBody FitnessClass fitnessClass) {
        try {
            FitnessClass createdClass = fitnessClassService.createClass(fitnessClass);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdClass);
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Invalid request format: " + e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping
    public ResponseEntity<List<FitnessClass>> getAllClasses() {
        return ResponseEntity.ok(fitnessClassService.getAllClasses());
    }

	/*
	 * @GetMapping("/search") public ResponseEntity<List<FitnessClass>>
	 * getClassesByName(@RequestParam String name) { return
	 * ResponseEntity.ok(classService.getClassesByName(name)); }
	 */
} 