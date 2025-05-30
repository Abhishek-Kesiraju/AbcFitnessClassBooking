package com.abc.fitness.repositories;

import com.abc.fitness.model.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
}
