package com.planner2.domain.planner.service;

import com.planner2.domain.comment.dto.response.GetCommentResponse;
import com.planner2.domain.comment.entity.Comment;
import com.planner2.domain.comment.repository.CommentRepository;
import com.planner2.domain.planner.dto.request.CreatePlannerRequest;
import com.planner2.domain.planner.dto.request.UpdatePlannerRequest;
import com.planner2.domain.planner.dto.response.*;
import com.planner2.domain.planner.entity.Planner;
import com.planner2.domain.planner.repository.PlannerRepository;
import com.planner2.domain.user.entity.User;
import com.planner2.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlannerService {
    private final PlannerRepository plannerRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;


    //region 일정 생성
    @Transactional
    public CreatePlannerResponse createPlanner(Long userId, CreatePlannerRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("없는 유저입니다.")
        );
        Planner planner = new Planner(
                user,
                request.getTitle(),
                request.getContent()
        );
        Planner savedPlanner = plannerRepository.save(planner);

        return new CreatePlannerResponse(
                savedPlanner.getId(),
                savedPlanner.getTitle(),
                savedPlanner.getContent(),
                savedPlanner.getCreatedAt(),
                savedPlanner.getModifiedAt()
        );
    }
    //endregion

    //region 일정 단건조회
    @Transactional(readOnly = true)
    public GetOnePlannerResponse getOnePlanner(Long plannerId) {
        Planner planner = plannerRepository.findById(plannerId).orElseThrow(
                () -> new IllegalArgumentException("일정이 존재하지 않습니다.")
        );
        GetPlannerResponse getPlannerResponse = new GetPlannerResponse(
                planner.getId(),
                planner.getTitle(),
                planner.getContent(),
                planner.getCreatedAt(),
                planner.getModifiedAt()
        );
        //선택일정의 댓글 조회
        List<Comment> comments = commentRepository.findCommentByPlanner_Id(plannerId);
        List<GetCommentResponse> commentsList = new ArrayList<>();

        for (Comment comment : comments) {
            GetCommentResponse dto = new GetCommentResponse(
                    comment.getId(),
                    comment.getContent(),
                    comment.getCreatedAt(),
                    comment.getModifiedAt()
            );
            commentsList.add(dto);
        }
        return new GetOnePlannerResponse(getPlannerResponse, commentsList);
    }
    //endregion

    //region 일정 전체조회
    @Transactional(readOnly = true)
    public List<GetPlannerResponse> getAllPlanner() {
        List<Planner> planners = plannerRepository.findAll();
        List<GetPlannerResponse> dtos = new ArrayList<>();

        for (Planner planner : planners) {
            GetPlannerResponse dto = new GetPlannerResponse(
                    planner.getId(),
                    planner.getTitle(),
                    planner.getContent(),
                    planner.getCreatedAt(),
                    planner.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }
    //endregion

    //region 일정 선택유저 전체조회
    public List<GetPlannerResponse> getUserPlanner(Long userId) {
        List<Planner> planners = plannerRepository.findByUserId(userId);
        List<GetPlannerResponse> dtos = new ArrayList<>();

        for (Planner planner : planners) {
            GetPlannerResponse dto = new GetPlannerResponse(
                    planner.getId(),
                    planner.getTitle(),
                    planner.getContent(),
                    planner.getCreatedAt(),
                    planner.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }
    //endregion

    //region 일정 전체조회 (페이지로)
    @Transactional(readOnly = true)
    public Page<GetPlannerPageResponse> getPlannersPage(int page, int size) {
        int pageSize = 10; // size 디폴트 10

        if (size > 0) {
            pageSize = size;
        }
        Pageable pageable = PageRequest.of(
                page,
                pageSize,
                Sort.by(Sort.Direction.DESC, "modifiedAt")
        );
        return plannerRepository.getPlannerPageWithComment(pageable);
    }
    //endregion

    //region 일정 수정
    @Transactional
    public UpdatePlannerResponse updatePlanner(Long plannerId, UpdatePlannerRequest request) {
        Planner planner = plannerRepository.findById(plannerId).orElseThrow(
                () -> new IllegalArgumentException("일정이 존재하지 않습니다.")
        );

        planner.updatePlanner(
                request.getTitle(),
                request.getContent()
        );

        return new UpdatePlannerResponse(
                planner.getTitle(),
                planner.getContent(),
                planner.getModifiedAt()
        );
    }
    //endregion

    //region 일정 삭제
    @Transactional
    public void deletePlanner(Long plannerId) {
        boolean existence = plannerRepository.existsById(plannerId);

        if (!existence) {
            throw new IllegalArgumentException("일정이 존재하지 않습니다.");
        }
        plannerRepository.deleteById(plannerId);
    }
    //endregion

}
