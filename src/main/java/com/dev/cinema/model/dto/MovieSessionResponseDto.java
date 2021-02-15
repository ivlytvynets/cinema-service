package com.dev.cinema.model.dto;

import java.time.LocalDateTime;

public class MovieSessionResponseDto {
    private Long movieSessionId;
    private LocalDateTime showTime;
    private Long movieId;
    private String movieTitle;
    private Long cinemaHallId;

    public void setMovieSessionId(Long movieSessionId) {
        this.movieSessionId = movieSessionId;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }
}
