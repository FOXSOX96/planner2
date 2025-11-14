package com.planner2.domain.user.dto.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateUserResponse {
    private final String name;
    private final String email;
    private final LocalDateTime modifiedAt;

    public UpdateUserResponse(String name, String email, LocalDateTime modifiedAt) {
        this.name = name;
        this.email = email;
        this.modifiedAt = modifiedAt;
    }
}
