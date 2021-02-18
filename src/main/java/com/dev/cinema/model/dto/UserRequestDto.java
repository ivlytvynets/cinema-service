package com.dev.cinema.model.dto;

import com.dev.cinema.lib.EmailValidator;
import com.dev.cinema.lib.PasswordValidator;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@PasswordValidator(field = "password",
        fieldMatch = "repeatPassword",
        message = "Passwords are different")
public class UserRequestDto {
    @EmailValidator
    private String email;
    @NotNull
    @Size(min = 6)
    private String password;
    private String repeatPassword;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
}
