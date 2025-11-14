package com.planner2.domain.planner.service;

import com.planner2.domain.planner.dto.request.CreatePlannerRequest;
import com.planner2.domain.planner.dto.request.UpdatePlannerRequest;
import com.planner2.domain.planner.dto.response.CreatePlannerResponse;
import com.planner2.domain.planner.dto.response.GetPlannerResponse;
import com.planner2.domain.planner.dto.response.UpdatePlannerResponse;
import com.planner2.domain.planner.entity.Planner;
import com.planner2.domain.planner.repository.PlannerRepository;
import com.planner2.domain.user.entity.User;
import com.planner2.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlannerService {
    private final PlannerRepository plannerRepository;
    private final UserRepository userRepository;


    //region 일정 생성
    @Transactional
    public CreatePlannerResponse createPlanner(Long userId, CreatePlannerRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("없는 유저입니다.")
        );
        Planner planner = new Planner(
                user,
                request.getTitle(),
                request.getContent()
        );
        Planner savedPlanner = plannerRepository.save(planner);

        return new CreatePlannerResponse (
                savedPlanner.getId(),
                savedPlanner.getTitle(),
                savedPlanner.getContent(),
                savedPlanner.getCreatedAt(),
                savedPlanner.getModifiedAt()
        );
    }
    //endregion

    //region 일정 단건조회
    @Transactional(readOnly = true)
    public GetPlannerResponse getOnePlanner(Long plannerId) {
        Planner planner = plannerRepository.findById(plannerId).orElseThrow(
                () -> new IllegalArgumentException("일정이 존재하지 않습니다.")
        );

        return new GetPlannerResponse(
                planner.getId(),
                planner.getTitle(),
                planner.getContent(),
                planner.getCreatedAt(),
                planner.getModifiedAt()
        );
    }
    //endregion

    //region 일정 전체조회
    @Transactional(readOnly = true)
    public List<GetPlannerResponse> getAllPlanner() {
        List<Planner> planners = plannerRepository.findAll();
        List<GetPlannerResponse> dtos = new ArrayList<>();

        for (Planner planner : planners) {
            GetPlannerResponse dto = new GetPlannerResponse(
                    planner.getId(),
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

    //region 일정 선택유저 전체조회
    public List<GetPlannerResponse> getUserPlanner(Long userId) {
        List<Planner> planners = plannerRepository.findByUserId(userId);
        List<GetPlannerResponse> dtos = new ArrayList<>();

        for (Planner planner : planners) {
            GetPlannerResponse dto = new GetPlannerResponse(
                    planner.getId(),
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
                () -> new IllegalArgumentException("일정이 존재하지 않습니다.")
        );

        planner.updatePlanner(
                request.getTitle(),
                request.getContent()
        );

        return new UpdatePlannerResponse(
                planner.getTitle(),
                planner.getContent(),
                planner.getModifiedAt()
        );
    }
    //endregion

    //region 일정 삭제
    @Transactional
    public void deletePlanner (Long plannerId){
        boolean existence = plannerRepository.existsById(plannerId);

        if (!existence) {
            throw new IllegalArgumentException("일정이 존재하지 않습니다.");
        }
        plannerRepository.deleteById(plannerId);
    }
    //endregion

}
