package com.dev.cinema.model.dto;

import java.time.LocalDateTime;

public class MovieSessionRequestDto {
    private LocalDateTime showTime;
    private Long movieId;
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
