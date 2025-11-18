package com.planner2.common.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

// - 필터 2번
@Slf4j
public class LoginCheckFilter implements Filter {

    // 화이트리스트
    private static final String[] whitelist = {"/logins", "/users"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // [ Servlet -> HttpServlet 변환 ]
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String requestURI = httpRequest.getRequestURI();

        try {
            if (isLoginCheckPath(requestURI)) {                                             // 화이트리스트 여부 체크
                HttpSession session = httpRequest.getSession(false);                 // 세션 가져오기
                if (session == null || session.getAttribute("email") == null) {       // 세션이 없거나 회원정보가 없는 경우
                    httpResponse.sendRedirect("/logins?redirectURL=" + requestURI); // 로그인 페이지로 리다이렉트
                    return;
                }
            }
            // 세션 검증에 성공하거나 화이트리스트인 경우
            chain.doFilter(request, response); // 다음 필터 호출
        } catch (Exception e) {
            throw e;
        } finally {
            log.info("필터2: [인가 종료] = {}", requestURI);
        }
    }

    /* 화이트 리스트인 경우 인증 체크X*/
    private boolean isLoginCheckPath(String requestURI) {
        return !PatternMatchUtils.simpleMatch(whitelist, requestURI);
    }
}


