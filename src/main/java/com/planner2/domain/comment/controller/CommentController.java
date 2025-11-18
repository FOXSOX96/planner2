package com.planner2.domain.comment.controller;

import com.planner2.domain.comment.dto.request.CreateCommentRequest;
import com.planner2.domain.comment.dto.request.UpdateCommentRequest;
import com.planner2.domain.comment.dto.response.CreateCommentResponse;
import com.planner2.domain.comment.dto.response.GetCommentResponse;
import com.planner2.domain.comment.dto.response.UpdateCommentResponse;
import com.planner2.domain.comment.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/planners/{plannerId}")
public class CommentController {
    private final CommentService commentService;

    //댓글 생성
    @PostMapping("/users/{userId}/comments")
    public ResponseEntity<CreateCommentResponse> createComment(@PathVariable Long userId, @PathVariable Long plannerId, @RequestBody @Valid CreateCommentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.createComment(userId, plannerId, request));
    }

    //선택일정의 댓글 조회
    @GetMapping("/comments")
    public ResponseEntity<List<GetCommentResponse>> getComment(@PathVariable Long plannerId) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getComment(plannerId));
    }

    //댓글 수정
    @PatchMapping("/comments/{commentId}")
    public ResponseEntity<UpdateCommentResponse> updateComment(@PathVariable Long commentId, @RequestBody @Valid UpdateCommentRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.updateComment(commentId, request));
    }

    //댓글 삭제
    @DeleteMapping("/comments/{commentId}")
    public  ResponseEntity<Void> deleteComment (@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
