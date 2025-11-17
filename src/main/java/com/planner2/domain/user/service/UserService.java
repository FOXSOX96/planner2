package com.planner2.domain.user.service;

import com.planner2.domain.common.config.PasswordEncoder;
import com.planner2.domain.common.exception.PasswordException;
import com.planner2.domain.user.dto.request.CreateUserRequest;
import com.planner2.domain.user.dto.request.DeleteUserRequest;
import com.planner2.domain.user.dto.request.UpdateUserRequest;
import com.planner2.domain.user.dto.response.CreateUserResponse;
import com.planner2.domain.user.dto.response.GetUserResponse;
import com.planner2.domain.user.dto.response.UpdateUserResponse;
import com.planner2.domain.user.entity.User;
import com.planner2.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //region 유저 생성 (회원가입)
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request) {
        User user = new User(
                request.getName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword())//암호화
        );
        User savedUser = userRepository.save(user);

        return new CreateUserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getCreatedAt(),
                savedUser.getModifiedAt()
        );
    }
    //endregion

    //region 유저 단건조회
    @Transactional(readOnly = true)
    public GetUserResponse getOneUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("유저가 존재하지 않습니다.")
        );

        return new GetUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );


    }
    //endregion

    //region 유저 전체조회
    @Transactional(readOnly = true)
    public List<GetUserResponse> getAllUser() {
        List<User> users = userRepository.findAll();
        List<GetUserResponse> dtos = new ArrayList<>();

        for (User user : users) {
            GetUserResponse dto = new GetUserResponse(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getCreatedAt(),
                    user.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }
    //endregion

    //region 유저 수정
    @Transactional
    public UpdateUserResponse updateUser(Long userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("유저가 존재하지 않습니다.")
        );
        //비밀번호 검증
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new PasswordException("비밀번호가 일치하지 않습니다.");
        }

        user.updateUser(
                request.getName(),
                passwordEncoder.encode(request.getNewPassword())//새 비밀번호 변경
        );

        return new UpdateUserResponse(
                user.getName(),
                user.getEmail(),
                user.getModifiedAt()
        );

    }
    //endregion

    //region 유저 삭제
    @Transactional
    public void deleteUser(Long userId, DeleteUserRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("유저가 존재하지 않습니다.")
        );
        //비밀번호 검증
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new PasswordException("비밀번호가 일치하지 않습니다.");
        }
        userRepository.deleteById(userId);
    }
    //endregion


}
