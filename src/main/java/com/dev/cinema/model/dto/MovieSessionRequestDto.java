package com.dev.cinema.model.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class MovieSessionRequestDto {
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
