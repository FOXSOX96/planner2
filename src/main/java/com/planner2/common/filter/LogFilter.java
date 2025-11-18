package com.planner2.common.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

// - 필터 1번
@Slf4j
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;   // dofilter의 매개변수타입으로 캐스팅
        String requestURI = httpRequest.getRequestURI();                 // URL
        String method = httpRequest.getMethod();                         // HTTP매서드

        long start = System.currentTimeMillis();
        log.info("필터1: [요청 시작] method={}, uri={}", method, requestURI);

        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            log.error("필터1: 에러 발생: {}", e.getMessage());
            throw e;
        } finally {
            long elapsed = System.currentTimeMillis() - start;
            log.info("필터1: [요청 종료] uri={}, 처리시간={}ms", requestURI, elapsed);
        }
    }
}
