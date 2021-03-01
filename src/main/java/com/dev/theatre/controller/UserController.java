package com.dev.theatre.controller;

import com.dev.theatre.exception.DataProcessingException;
import com.dev.theatre.model.User;
import com.dev.theatre.model.dto.UserResponseDto;
import com.dev.theatre.service.UserMapper;
import com.dev.theatre.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto getByEmail(@RequestParam String email) {
        User user = userService.findByEmail(email).orElseThrow(() ->
                new DataProcessingException("Can't get user with email: " + email));
        return userMapper.getResponseDto(user);
    }
}
