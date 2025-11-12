package com.planner2.domain.planner.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdatePlannerResponse {
    private final String name;
    private final String title;
    private final String content;
    private final LocalDateTime modifiedAt;

    public UpdatePlannerResponse(String name, String title, String content, LocalDateTime modifiedAt) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.modifiedAt = modifiedAt;
    }
}
