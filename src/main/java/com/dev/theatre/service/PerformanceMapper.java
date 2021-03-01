package com.dev.theatre.service;

import com.dev.theatre.model.Performance;
import com.dev.theatre.model.dto.PerformanceRequestDto;
import com.dev.theatre.model.dto.PerformanceResponseDto;

public interface PerformanceMapper {
    PerformanceResponseDto getResponseDto(Performance performance);

    Performance getEntity(PerformanceRequestDto performanceRequestDto);
}
