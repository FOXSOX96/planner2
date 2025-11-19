package com.planner2.domain.planner.repository;

import com.planner2.domain.planner.dto.projection.GetPlannerPageResponse;
import com.planner2.domain.planner.entity.Planner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlannerRepository extends JpaRepository<Planner, Long> {
    List<Planner> findByUserId(Long userId); //SELECT p FROM Planner p WHERE p.user.id = :userId

    //참조: 이 경우 @Query가 간단하지만 조건들에 변수가 붙을수록 QueryDSL이 효율적이다.
    @Query("""
        SELECT new com.planner2.domain.planner.dto.projection.GetPlannerPageResponse(
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
