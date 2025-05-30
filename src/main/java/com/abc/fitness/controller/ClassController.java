package com.abc.fitness.controller;

import com.abc.fitness.model.ClassEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    @PostMapping
    public ResponseEntity<?> createClass(@RequestBody ClassEntity classEntity){
        //call createClassService
        return null;
    }

}
