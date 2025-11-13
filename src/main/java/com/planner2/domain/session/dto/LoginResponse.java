package com.planner2.domain.session.dto;

import lombok.Getter;

@Getter
public class LoginResponse {
    private final Long id;
    private final String name;
    private final String email;

    //User의 id, name, email을 받아야함
    public LoginResponse(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
