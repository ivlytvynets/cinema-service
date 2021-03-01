package com.dev.theatre.lib.impl;

import com.dev.theatre.lib.PasswordValidator;
import com.dev.theatre.model.dto.UserRequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidatorImpl
        implements ConstraintValidator<PasswordValidator, UserRequestDto> {
    @Override
    public boolean isValid(UserRequestDto userRequestDto,
                           ConstraintValidatorContext constraintValidatorContext) {
        return userRequestDto != null && userRequestDto.getPassword() != null
                && userRequestDto.getPassword().equals(userRequestDto.getRepeatPassword());
    }
}
