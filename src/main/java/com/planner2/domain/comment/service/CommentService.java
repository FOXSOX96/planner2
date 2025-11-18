package com.planner2.domain.comment.service;

import com.planner2.domain.comment.dto.request.CreateCommentRequest;
import com.planner2.domain.comment.dto.response.CreateCommentResponse;
import com.planner2.domain.comment.entity.Comment;
import com.planner2.domain.comment.repository.CommentRepository;
import com.planner2.domain.planner.entity.Planner;
import com.planner2.domain.planner.repository.PlannerRepository;
import com.planner2.domain.user.entity.User;
import com.planner2.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PlannerRepository plannerRepository;

    //region 댓글 생성
    @Transactional
    public CreateCommentResponse createComment(Long userId,Long plannerId, CreateCommentRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("없는 유저입니다.")
        );
        Planner planner = plannerRepository.findById(plannerId).orElseThrow(
                () -> new IllegalArgumentException("없는 일정입니다.")
        );

        Comment comment = new Comment(
                user,
                planner,
                request.getContent()
        );
        Comment savedComment = commentRepository.save(comment);

        return new CreateCommentResponse (
                savedComment.getId(),
                savedComment.getContent(),
                savedComment.getCreatedAt(),
                savedComment.getModifiedAt()
        );
    }
    //endregion

}
