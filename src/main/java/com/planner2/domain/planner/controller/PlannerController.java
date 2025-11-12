package com.planner2.domain.planner.controller;

import com.planner2.domain.planner.dto.CreatePlannerRequest;
import com.planner2.domain.planner.dto.CreatePlannerResponse;
import com.planner2.domain.planner.service.PlannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlannerController {
    private final PlannerService plannerService;

    //일정 생성
    @PostMapping("/planners")
    public ResponseEntity<CreatePlannerResponse> createPlanner (@RequestBody CreatePlannerRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(plannerService.createPlanner(request));
    }


    //일정 단건 조회

    //일정 전체 조회

    //일정 수정

    //일정 삭제

}
