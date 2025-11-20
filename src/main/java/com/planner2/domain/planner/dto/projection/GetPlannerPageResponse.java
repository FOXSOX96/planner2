package com.planner2.domain.planner.dto.projection;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetPlannerPageResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String userName;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final Long commentCount;

    public GetPlannerPageResponse(Long id, String title, String content, String userName, LocalDateTime createdAt, LocalDateTime modifiedAt, Long commentCount) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.commentCount = commentCount;
    }
}
