package com.planner2.common.exception;

public class PasswordException extends RuntimeException{

    public PasswordException() {
        super("비밀번호가 일치하지 않습니다.");
    }

    public PasswordException(String message) {
        super(message);
    }

}
