package com.dev.theatre.service.impl;

import com.dev.theatre.model.User;
import com.dev.theatre.model.dto.UserResponseDto;
import com.dev.theatre.service.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserResponseDto getResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }
}
