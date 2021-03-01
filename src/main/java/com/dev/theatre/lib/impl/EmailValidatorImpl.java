package com.dev.theatre.lib.impl;

import com.dev.theatre.lib.EmailValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidatorImpl implements ConstraintValidator<EmailValidator, String> {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return email != null && email.matches(EMAIL_REGEX);
    }
}
