package com.dev.cinema.exception;

public class SessionFactoryInitializationException extends RuntimeException {
    public SessionFactoryInitializationException(String message, Throwable ex) {
        super(message, ex);
    }
}
