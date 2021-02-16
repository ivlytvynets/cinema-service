package com.dev.cinema.service;

import com.dev.cinema.model.User;
import com.dev.cinema.model.dto.UserResponseDto;

public interface UserMapper {
    UserResponseDto getResponseDto(User user);
}
