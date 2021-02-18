package com.dev.cinema.controller;

import com.dev.cinema.model.CinemaHall;
import com.dev.cinema.model.dto.CinemaHallRequestDto;
import com.dev.cinema.model.dto.CinemaHallResponseDto;
import com.dev.cinema.service.CinemaHallMapper;
import com.dev.cinema.service.CinemaHallService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallMapper cinemaHallMapper;
    private final CinemaHallService cinemaHallService;

    public CinemaHallController(CinemaHallMapper cinemaHallMapper,
                                CinemaHallService cinemaHallService) {
        this.cinemaHallMapper = cinemaHallMapper;
        this.cinemaHallService = cinemaHallService;
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        List<CinemaHall> cinemaHalls = cinemaHallService.getAll();
        return cinemaHalls
                .stream()
                .map(cinemaHallMapper::getResponseDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void add(@RequestBody @Valid CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = cinemaHallMapper.getEntity(cinemaHallRequestDto);
        cinemaHallService.add(cinemaHall);
    }
}
