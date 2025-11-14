package com.planner2.domain.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateUserRequest {
    @NotBlank(message = "이름은 필수로 기입해야합니다.")
    @Size(max = 10, message = "이름은 10자 이내여야 합니다.")
    private String name;
    @NotBlank(message = "이메일은 필수로 기입해야합니다.")
    @Email(message = "이메일 형식으로 입력해야 합니다.")
    @Size(max = 30, message = "이메일은 30자 이내여야 합니다.")
    private String email;
    @NotBlank(message = "비밀번호는 필수로 기입해야합니다.")
    @Pattern(regexp = "/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/",
            message = "비밀번호는 영문 숫자 특수기호 조합의 8~15자여야 합니다.")
    private String password;

}
