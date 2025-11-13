package com.planner2.domain.session.dto;

import com.planner2.domain.user.entity.User;
import lombok.Getter;

@Getter
public class LoginResponse {
    private final Long id;
    private final String name;
    private final String email;

    public LoginResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
