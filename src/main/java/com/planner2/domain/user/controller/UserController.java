package com.planner2.domain.user.controller;

import com.planner2.domain.user.dto.*;
import com.planner2.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //유저 생성 (회원가입)
    @PostMapping("/users")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(request));
    }

    //유저 단건조회
    @GetMapping("/users/{userId}")
    public ResponseEntity<GetUserResponse> getOneUser(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getOneUser(userId));
    }

    //유저 전체조회
    @GetMapping("/users")
    public ResponseEntity<List<GetUserResponse>> getAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    //유저 수정
    @PatchMapping("/users/{userId}")
    public ResponseEntity<UpdateUserResponse> updateUser(@PathVariable Long userId, @RequestBody UpdateUserRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(userId, request));
    }

    //유저 삭제
    @DeleteMapping("/users/{userId}")
    public  ResponseEntity<Void> deleteUser (@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
