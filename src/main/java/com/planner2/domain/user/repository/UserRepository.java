package com.planner2.domain.user.repository;

import com.planner2.domain.planner.entity.Planner;
import com.planner2.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
}
