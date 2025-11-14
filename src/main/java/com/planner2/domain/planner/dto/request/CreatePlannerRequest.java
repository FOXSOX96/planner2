package com.planner2.domain.planner.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreatePlannerRequest {
    @NotBlank(message = "제목은 필수로 기입해야합니다.")
    @Size(max = 50, message = "제목은 50자 이내여야 합니다.")
    private String title;
    @NotBlank(message = "내용은 필수로 기입해야합니다.")
    @Size(max = 500, message = "내용은 500자 이내여야 합니다.")
    private String content;
}
