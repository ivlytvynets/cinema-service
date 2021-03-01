package com.dev.theatre.service.impl;

import com.dev.theatre.model.Performance;
import com.dev.theatre.model.dto.PerformanceRequestDto;
import com.dev.theatre.model.dto.PerformanceResponseDto;
import com.dev.theatre.service.PerformanceMapper;
import org.springframework.stereotype.Component;

@Component
public class PerformanceMapperImpl implements PerformanceMapper {

    @Override
    public PerformanceResponseDto getResponseDto(Performance performance) {
        PerformanceResponseDto performanceResponseDto = new PerformanceResponseDto();
        performanceResponseDto.setId(performance.getId());
        performanceResponseDto.setTitle(performance.getTitle());
        performanceResponseDto.setDescription(performance.getDescription());
        return performanceResponseDto;
    }

    @Override
    public Performance getEntity(PerformanceRequestDto performanceRequestDto) {
        Performance performance = new Performance();
        performance.setTitle(performanceRequestDto.getTitle());
        performance.setDescription(performanceRequestDto.getDescription());
        return performance;
    }
}
