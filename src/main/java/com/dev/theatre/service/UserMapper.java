package com.dev.theatre.service;

import com.dev.theatre.model.User;
import com.dev.theatre.model.dto.UserResponseDto;

public interface UserMapper {
    UserResponseDto getResponseDto(User user);
}
