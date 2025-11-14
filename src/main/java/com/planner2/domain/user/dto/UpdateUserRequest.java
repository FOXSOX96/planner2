package com.planner2.domain.user.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateUserRequest {
    @Size(min = 1, max = 10, message = "이름은 1~10자여야 합니다.")
    private String name;
    @Pattern(regexp = "/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/",
            message = "비밀번호는 영문 숫자 특수기호 조합의 8~15자여야 합니다.")
    private String password;
}
