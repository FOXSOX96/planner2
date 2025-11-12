package com.planner2.domain.planner.repository;

import com.planner2.domain.planner.entity.Planner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlannerRepository extends JpaRepository<Planner, Long> {
    List<Planner> findByUserId(Long userId); //SELECT p FROM Planner p WHERE p.user.id = :userId
}
