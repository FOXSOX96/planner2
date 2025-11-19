package com.planner2.domain.planner.controller;

import com.planner2.domain.planner.dto.projection.GetPlannerPageResponse;
import com.planner2.domain.planner.dto.request.CreatePlannerRequest;
import com.planner2.domain.planner.dto.request.UpdatePlannerRequest;
import com.planner2.domain.planner.dto.response.*;
import com.planner2.domain.planner.service.PlannerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlannerController {
    private final PlannerService plannerService;

    //일정 생성
    @PostMapping("/users/{userId}/planners")
    public ResponseEntity<CreatePlannerResponse> createPlanner(@PathVariable Long userId, @RequestBody @Valid CreatePlannerRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(plannerService.createPlanner(userId, request));
    }

    //일정 단건조회
    @GetMapping("/planners/{plannerId}")
    public ResponseEntity<GetOnePlannerResponse> getOnePlanner(@PathVariable Long plannerId) {
        return ResponseEntity.status(HttpStatus.OK).body(plannerService.getOnePlanner(plannerId));
    }

    //일정 전체조회 -url 따로 뺌
    @GetMapping("/planners/all")
    public ResponseEntity<List<GetPlannerResponse>> getAllPlanner() {
        return ResponseEntity.status(HttpStatus.OK).body(plannerService.getAllPlanner());
    }

    //일정 전체조회 (페이지방식)
    @GetMapping("/planners")
    public ResponseEntity<Page<GetPlannerPageResponse>> getPlannerPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.status(HttpStatus.OK).body(plannerService.getPlannersPage(page, size));
    }

    //일정 선택유저 전체조회
    @GetMapping("/users/{userId}/planners")
    public ResponseEntity<List<GetPlannerResponse>> getUserPlanner(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(plannerService.getUserPlanner(userId));
    }

    //일정 수정
    @PatchMapping("/planners/{plannerId}")
    public ResponseEntity<UpdatePlannerResponse> updatePlanner(@PathVariable Long plannerId, @RequestBody @Valid UpdatePlannerRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(plannerService.updatePlanner(plannerId, request));
    }

    //일정 삭제
    @DeleteMapping("/planners/{plannerId}")
    public  ResponseEntity<Void> deletePlanner (@PathVariable Long plannerId) {
        plannerService.deletePlanner(plannerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
