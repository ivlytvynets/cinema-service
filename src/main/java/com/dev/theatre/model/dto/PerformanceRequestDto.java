package com.dev.theatre.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PerformanceRequestDto {
    @NotNull
    @Size(min = 2)
    private String title;
    @NotNull
    @Size(min = 4)
    private String description;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
