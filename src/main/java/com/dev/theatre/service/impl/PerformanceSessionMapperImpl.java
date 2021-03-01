package com.dev.theatre.service.impl;

import com.dev.theatre.model.PerformanceSession;
import com.dev.theatre.model.dto.PerformanceSessionRequestDto;
import com.dev.theatre.model.dto.PerformanceSessionResponseDto;
import com.dev.theatre.service.PerformanceService;
import com.dev.theatre.service.PerformanceSessionMapper;
import com.dev.theatre.service.TheatreStageService;
import org.springframework.stereotype.Component;

@Component
public class PerformanceSessionMapperImpl implements PerformanceSessionMapper {
    private final PerformanceService performanceService;
    private final TheatreStageService theatreStageService;

    public PerformanceSessionMapperImpl(PerformanceService performanceService,
                                        TheatreStageService theatreStageService) {
        this.performanceService = performanceService;
        this.theatreStageService = theatreStageService;
    }

    @Override
    public PerformanceSessionResponseDto getResponseDto(PerformanceSession performanceSession) {
        PerformanceSessionResponseDto performanceSessionResponseDto =
                new PerformanceSessionResponseDto();
        performanceSessionResponseDto.setMovieSessionId(performanceSession.getId());
        performanceSessionResponseDto.setShowTime(performanceSession.getShowTime());
        performanceSessionResponseDto.setMovieId(performanceSession.getMovie().getId());
        performanceSessionResponseDto.setMovieTitle(performanceSession.getMovie().getTitle());
        performanceSessionResponseDto.setCinemaHallId(performanceSession.getCinemaHall().getId());
        return performanceSessionResponseDto;
    }

    @Override
    public PerformanceSession getEntity(PerformanceSessionRequestDto performanceSessionRequestDto) {
        PerformanceSession performanceSession = new PerformanceSession();
        performanceSession.setMovie(performanceService.get(performanceSessionRequestDto
                .getMovieId()));
        performanceSession.setCinemaHall(theatreStageService.get(performanceSessionRequestDto
                .getCinemaHallId()));
        performanceSession.setShowTime(performanceSessionRequestDto.getShowTime());
        return performanceSession;
    }
}
