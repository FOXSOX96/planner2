package com.planner2.domain.planner.dto.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdatePlannerResponse {
    private final String title;
    private final String content;
    private final LocalDateTime modifiedAt;

    public UpdatePlannerResponse(String title, String content, LocalDateTime modifiedAt) {
        this.title = title;
        this.content = content;
        this.modifiedAt = modifiedAt;
    }
}
