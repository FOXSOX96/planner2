package com.planner2.domain.session.service;

import com.planner2.domain.session.dto.LoginRequest;
import com.planner2.domain.session.dto.LoginResponse;
import com.planner2.domain.user.entity.User;
import com.planner2.domain.user.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttribute;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final UserRepository userRepository;

    //region 로그인 (세션 생성)
    @Transactional
    public LoginResponse loginSession(LoginRequest request, HttpSession httpSession) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user == null || request.getEmail() == null) {
            throw new IllegalStateException("해당 이메일의 사용자가 존재하지 않습니다.");
        }
        if (!request.getPassword().equals(user.getPassword())) {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }

        httpSession.setAttribute("email", request.getEmail()); //

        LoginResponse loginResponse = new LoginResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
        return loginResponse;
    }
    //endregion

}
