package com.planner2.domain.user.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetUserResponse {
    private final Long id;
    private final String name;
    private final String email;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public GetUserResponse(Long id, String name, String email, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
