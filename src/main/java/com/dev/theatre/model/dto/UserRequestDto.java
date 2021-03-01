package com.dev.theatre.model.dto;

import com.dev.theatre.lib.EmailValidator;
import com.dev.theatre.lib.PasswordValidator;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@PasswordValidator(message = "Passwords are different")
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
