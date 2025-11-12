package com.planner2.domain.planner.service;

import com.planner2.domain.planner.dto.CreatePlannerRequest;
import com.planner2.domain.planner.dto.CreatePlannerResponse;
import com.planner2.domain.planner.entity.Planner;
import com.planner2.domain.planner.repository.PlannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PlannerService {
    private final PlannerRepository plannerRepository;


    //region 일정생성
    @Transactional
    public CreatePlannerResponse createPlanner(CreatePlannerRequest request) {
        Planner planner = new Planner(
                request.getName(),
                request.getTitle(),
                request.getContent()
        );
        Planner savedPlanner = plannerRepository.save(planner);

        return new CreatePlannerResponse (
                savedPlanner.getId(),
                savedPlanner.getName(),
                savedPlanner.getTitle(),
                savedPlanner.getContent(),
                savedPlanner.getCreatedAt(),
                savedPlanner.getModifiedAt()
        );
    }
    //endregion

}
