package com.planner2.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateUserRequest {
    @Size(min = 1, max = 10, message = "이름은 1~10자여야 합니다.")
    private String name;
    @Email(message = "이메일 형식으로 입력해야 합니다.")
    @Size(min = 1, max = 50, message = "이메일은 1~50자여야 합니다.")
    private String email;
    @Pattern(regexp = "/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/",
            message = "비밀번호는 영문 숫자 특수기호 조합의 8~15자여야 합니다.")
    private String password;

}
