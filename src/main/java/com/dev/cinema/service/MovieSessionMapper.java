package com.dev.cinema.service;

import com.dev.cinema.model.MovieSession;
import com.dev.cinema.model.dto.MovieSessionRequestDto;
import com.dev.cinema.model.dto.MovieSessionResponseDto;

public interface MovieSessionMapper {
    MovieSessionResponseDto getResponseDto(MovieSession movieSession);

    MovieSession getEntity(MovieSessionRequestDto movieSessionRequestDto);
}
