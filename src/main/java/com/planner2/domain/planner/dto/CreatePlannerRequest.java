package com.planner2.domain.planner.dto;

import lombok.Getter;

@Getter
public class CreatePlannerRequest {
    private String title;
    private String content;
}
