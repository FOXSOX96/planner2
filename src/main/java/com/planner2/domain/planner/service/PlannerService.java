package com.planner2.domain.planner.service;

import com.planner2.domain.planner.dto.*;
import com.planner2.domain.planner.entity.Planner;
import com.planner2.domain.planner.repository.PlannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlannerService {
    private final PlannerRepository plannerRepository;


    //region 일정 생성
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

    //region 일정 단건조회
    @Transactional
    public GetPlannerResponse getOnePlanner(Long plannerId) {
        Planner planner = plannerRepository.findById(plannerId).orElseThrow(
                () -> new IllegalStateException("일정이 존재하지 않습니다.")
        );

        return new GetPlannerResponse(
                planner.getId(),
                planner.getName(),
                planner.getTitle(),
                planner.getContent(),
                planner.getCreatedAt(),
                planner.getModifiedAt()
        );


    }
    //endregion

    //region 일정 전체조회
    @Transactional
    public List<GetPlannerResponse> getAllPlanner() {
        List<Planner> planners = plannerRepository.findAll();
        List<GetPlannerResponse> dtos = new ArrayList<>();

        for (Planner planner : planners) {
            GetPlannerResponse dto = new GetPlannerResponse(
                    planner.getId(),
                    planner.getName(),
                    planner.getTitle(),
                    planner.getContent(),
                    planner.getCreatedAt(),
                    planner.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }
    //endregion

    //region 일정 수정
    @Transactional
    public UpdatePlannerResponse updatePlanner(Long plannerId, UpdatePlannerRequest request) {
        Planner planner = plannerRepository.findById(plannerId).orElseThrow(
                () -> new IllegalStateException("일정이 존재하지 않습니다.")
        );

        planner.updatePlanner(
                request.getName(),
                request.getTitle(),
                request.getContent()
        );

        return new UpdatePlannerResponse(
                planner.getName(),
                planner.getTitle(),
                planner.getContent(),
                planner.getModifiedAt()
        );

    }
    //endregion



}
