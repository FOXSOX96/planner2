package com.planner2.domain.comment.controller;

import com.planner2.domain.comment.dto.request.CreateCommentRequest;
import com.planner2.domain.comment.dto.response.CreateCommentResponse;
import com.planner2.domain.comment.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    //댓글 생성
    @PostMapping("/users/{userId}/planners/{plannerId}/comments")
    public ResponseEntity<CreateCommentResponse> createComment(@PathVariable Long userId, @PathVariable Long plannerId, @RequestBody @Valid CreateCommentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.createComment(userId, plannerId, request));
    }

}
