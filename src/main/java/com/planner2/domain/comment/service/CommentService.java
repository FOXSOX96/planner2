package com.planner2.domain.comment.service;

import com.planner2.domain.comment.dto.request.CreateCommentRequest;
import com.planner2.domain.comment.dto.request.UpdateCommentRequest;
import com.planner2.domain.comment.dto.response.CreateCommentResponse;
import com.planner2.domain.comment.dto.response.GetCommentResponse;
import com.planner2.domain.comment.dto.response.UpdateCommentResponse;
import com.planner2.domain.comment.entity.Comment;
import com.planner2.domain.comment.repository.CommentRepository;
import com.planner2.domain.planner.entity.Planner;
import com.planner2.domain.planner.repository.PlannerRepository;
import com.planner2.domain.user.entity.User;
import com.planner2.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PlannerRepository plannerRepository;

    //region 댓글 생성
    @Transactional
    public CreateCommentResponse createComment(Long userId, Long plannerId, CreateCommentRequest request) {
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

        return new CreateCommentResponse(
                savedComment.getId(),
                savedComment.getContent(),
                savedComment.getCreatedAt(),
                savedComment.getModifiedAt()
        );
    }
    //endregion

    //region 선택일정의 댓글 조회
    @Transactional(readOnly = true)
    public List<GetCommentResponse> getComment(Long plannerId) {
        List<Comment> comments = commentRepository.findCommentByPlanner_Id(plannerId);

        List<GetCommentResponse> dtos = new ArrayList<>();

        for (Comment comment : comments) {
            GetCommentResponse dto = new GetCommentResponse(
                    comment.getId(),
                    comment.getContent(),
                    comment.getCreatedAt(),
                    comment.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }
    //endregion

    //region 댓글 수정
    @Transactional
    public UpdateCommentResponse updateComment(Long commentId, UpdateCommentRequest request) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );

        comment.updateComment(
                request.getContent()
        );

        return new UpdateCommentResponse(
                comment.getContent(),
                comment.getModifiedAt()
        );
    }
    //endregion

    //region 댓글 삭제
    @Transactional
    public void deleteComment (Long commentId){
        boolean existence = commentRepository.existsById(commentId);

        if (!existence) {
            throw new IllegalArgumentException("댓글이 존재하지 않습니다.");
        }
        commentRepository.deleteById(commentId);
    }
    //endregion


}
