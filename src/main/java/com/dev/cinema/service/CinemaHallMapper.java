package com.dev.cinema.service;

import com.dev.cinema.model.CinemaHall;
import com.dev.cinema.model.dto.CinemaHallRequestDto;
import com.dev.cinema.model.dto.CinemaHallResponseDto;

public interface CinemaHallMapper {
    CinemaHallResponseDto getResponseDto(CinemaHall cinemaHall);

    CinemaHall getEntity(CinemaHallRequestDto cinemaHallRequestDto);
}
