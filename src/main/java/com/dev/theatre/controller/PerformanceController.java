package com.dev.theatre.controller;

import com.dev.theatre.model.Performance;
import com.dev.theatre.model.dto.PerformanceRequestDto;
import com.dev.theatre.model.dto.PerformanceResponseDto;
import com.dev.theatre.service.PerformanceMapper;
import com.dev.theatre.service.PerformanceService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class PerformanceController {
    private final PerformanceService performanceService;
    private final PerformanceMapper performanceMapper;

    public PerformanceController(PerformanceService performanceService,
                                 PerformanceMapper performanceMapper) {
        this.performanceService = performanceService;
        this.performanceMapper = performanceMapper;
    }

    @GetMapping
    public List<PerformanceResponseDto> getAll() {
        List<Performance> performances = performanceService.getAll();
        return performances
                .stream()
                .map(performanceMapper::getResponseDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void add(@RequestBody @Valid PerformanceRequestDto performanceRequestDto) {
        Performance performance = performanceMapper.getEntity(performanceRequestDto);
        performanceService.add(performance);
    }
}
