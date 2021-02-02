package com.dev.cinema.security.impl;

import com.dev.cinema.exception.AuthenticationException;
import com.dev.cinema.lib.Service;
import com.dev.cinema.model.User;
import com.dev.cinema.security.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public User login(String email, String password) throws AuthenticationException {
        return null;
    }

    @Override
    public User register(String email, String password) {
        return null;
    }
}
