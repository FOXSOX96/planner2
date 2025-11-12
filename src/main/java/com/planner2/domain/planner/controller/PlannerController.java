package com.planner2.domain.planner.controller;

import com.planner2.domain.planner.dto.*;
import com.planner2.domain.planner.service.PlannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlannerController {
    private final PlannerService plannerService;

    //일정 생성
    @PostMapping("/planners")
    public ResponseEntity<CreatePlannerResponse> createPlanner (@RequestBody CreatePlannerRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(plannerService.createPlanner(request));
    }

    //일정 단건조회
    @GetMapping("/planners/{plannerId}")
    public ResponseEntity<GetPlannerResponse> getOnePlanner (@PathVariable Long plannerId){
        return ResponseEntity.status(HttpStatus.OK).body(plannerService.getOnePlanner(plannerId));
    }

    //일정 전체조회
    @GetMapping("/planners")
    public ResponseEntity<List<GetPlannerResponse>> getAllPlanner (){
        return ResponseEntity.status(HttpStatus.OK).body(plannerService.getAllPlanner());
    }

    //일정 수정
    @PatchMapping("/planners/{plannerId}")
    public ResponseEntity<UpdatePlannerResponse> updatePlanner (@PathVariable Long plannerId, @RequestBody UpdatePlannerRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(plannerService.updatePlanner(plannerId, request));
    }

    //일정 삭제

}
