package com.planner2.domain.session.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginRequest {
    @NotBlank(message = "이메일은 필수로 기입해야합니다.")
    private String email;
    @NotBlank(message = "비밀번호는 필수로 기입해야합니다.")
    private String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}