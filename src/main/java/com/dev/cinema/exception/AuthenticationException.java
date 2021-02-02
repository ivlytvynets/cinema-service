package com.dev.cinema.exception;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable ex) {
        super(message, ex);
    }
}
