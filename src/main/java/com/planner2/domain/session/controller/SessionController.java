package com.planner2.domain.session.controller;

import com.planner2.domain.session.dto.LoginRequest;
import com.planner2.domain.session.dto.LoginResponse;
import com.planner2.domain.session.service.SessionService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    //로그인 (세션 생성)
    @PostMapping("/logins")
    public ResponseEntity<LoginResponse> loginSession(@RequestBody LoginRequest request, HttpSession httpSession) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sessionService.loginSession(request, httpSession));
    }



}