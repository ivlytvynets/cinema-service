package com.dev.cinema.service;

import com.dev.cinema.model.Movie;
import com.dev.cinema.model.dto.MovieRequestDto;
import com.dev.cinema.model.dto.MovieResponseDto;

public interface MovieMapper {
    MovieResponseDto getResponseDto(Movie movie);

    Movie getEntity(MovieRequestDto movieRequestDto);
}
