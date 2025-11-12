package com.planner2.domain.planner.controller;

import com.planner2.domain.planner.service.PlannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlannerController {
    private final PlannerService plannerService;



}
