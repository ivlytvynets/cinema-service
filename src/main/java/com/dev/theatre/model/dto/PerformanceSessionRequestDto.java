package com.dev.theatre.model.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class PerformanceSessionRequestDto {
    @NotNull
    private LocalDateTime showTime;
    @NotNull
    private Long movieId;
    @NotNull
    private Long cinemaHallId;

    public Long getMovieId() {
        return movieId;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }
}
