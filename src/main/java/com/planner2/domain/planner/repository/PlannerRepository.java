package com.planner2.domain.planner.repository;

import com.planner2.domain.planner.dto.response.GetPlannerPageResponse;
import com.planner2.domain.planner.entity.Planner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlannerRepository extends JpaRepository<Planner, Long> {
    List<Planner> findByUserId(Long userId); //SELECT p FROM Planner p WHERE p.user.id = :userId
    @Query("""
        SELECT new com.planner2.domain.planner.dto.response.GetPlannerPageResponse(
            p.id,
            p.title,
            p.content,
            p.user.name,
            p.createdAt,
            p.modifiedAt,
            COUNT(c)
        )
        FROM Planner p
        LEFT JOIN Comment c ON c.planner.id = p.id
        GROUP BY p.id
    """)
    Page<GetPlannerPageResponse> getPlannerPageWithComment(Pageable pageable);
}
