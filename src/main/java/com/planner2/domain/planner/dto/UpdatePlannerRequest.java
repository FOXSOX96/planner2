package com.planner2.domain.planner.dto;

import lombok.Getter;

@Getter
public class UpdatePlannerRequest {
    private String name;
    private String title;
    private String content;
}
