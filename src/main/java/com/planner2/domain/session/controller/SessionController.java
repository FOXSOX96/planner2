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

    //로그아웃 (세션 삭제)
    @PostMapping("/logouts")
    public ResponseEntity<Void> logoutSession(HttpSession httpSession) {
        httpSession.invalidate();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //세션 확인
    @GetMapping("/sessions/tests")
    public ResponseEntity<Void> test(@SessionAttribute(name = "email", required = false) String email) {
        if (email == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}