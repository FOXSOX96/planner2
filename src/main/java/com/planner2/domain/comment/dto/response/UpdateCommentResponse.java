package com.planner2.domain.comment.dto.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateCommentResponse {
    private final String content;
    private final LocalDateTime modifiedAt;

    public UpdateCommentResponse(String content, LocalDateTime modifiedAt) {
        this.content = content;
        this.modifiedAt = modifiedAt;
    }
}
