package com.planner2.domain.planner.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdatePlannerRequest {
    @Size(min = 1, max = 50, message = "제목은 1~50자여야 합니다.")
    private String title;
    @Size(min = 1, max = 500, message = "내용은 1~500자여야 합니다.")
    private String content;
}
