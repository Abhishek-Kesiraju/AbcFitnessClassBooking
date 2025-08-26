package com.abc.fitness.repositories;

import com.abc.fitness.model.FitnessClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface FitnessClassRepository extends JpaRepository<FitnessClass, Long> {

    List<FitnessClass> findByName(String name);
} 