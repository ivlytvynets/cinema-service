package com.dev.cinema.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CinemaHallRequestDto {
    @Min(10)
    private int capacity;
    @NotNull
    @Size(min = 4)
    private String description;

    public int getCapacity() {
        return capacity;
    }

    public String getDescription() {
        return description;
    }
}
