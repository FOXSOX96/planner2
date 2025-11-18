package com.planner2.domain.comment.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateCommentRequest {
    @NotBlank(message = "내용은 필수로 기입해야합니다.")
    @Size(max = 100, message = "내용은 100자 이내여야 합니다.")
    private String content;
}
