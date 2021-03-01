package com.dev.theatre.service;

import com.dev.theatre.model.PerformanceSession;
import com.dev.theatre.model.dto.PerformanceSessionRequestDto;
import com.dev.theatre.model.dto.PerformanceSessionResponseDto;

public interface PerformanceSessionMapper {
    PerformanceSessionResponseDto getResponseDto(PerformanceSession performanceSession);

    PerformanceSession getEntity(PerformanceSessionRequestDto performanceSessionRequestDto);
}
