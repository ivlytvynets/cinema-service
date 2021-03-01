package com.dev.theatre.controller;

import com.dev.theatre.model.PerformanceSession;
import com.dev.theatre.model.dto.PerformanceSessionRequestDto;
import com.dev.theatre.model.dto.PerformanceSessionResponseDto;
import com.dev.theatre.service.PerformanceSessionMapper;
import com.dev.theatre.service.PerformanceSessionService;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/performance-sessions")
public class PerformanceSessionController {
    private final PerformanceSessionService performanceSessionService;
    private final PerformanceSessionMapper performanceSessionMapper;

    public PerformanceSessionController(PerformanceSessionService performanceSessionService,
                                        PerformanceSessionMapper performanceSessionMapper) {
        this.performanceSessionService = performanceSessionService;
        this.performanceSessionMapper = performanceSessionMapper;
    }

    @PostMapping
    public void add(@RequestBody @Valid PerformanceSessionRequestDto performanceSessionRequestDto) {
        PerformanceSession performanceSession = performanceSessionMapper
                .getEntity(performanceSessionRequestDto);
        performanceSessionService.add(performanceSession);
    }

    @GetMapping("/available")
    public List<PerformanceSessionResponseDto> get(@RequestParam Long movieId,
                                                   @RequestParam
                                      @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        List<PerformanceSession> performanceSessions = performanceSessionService
                .findAvailableSessions(movieId,
                date);
        return performanceSessions
                .stream()
                .map(performanceSessionMapper::getResponseDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void put(@PathVariable Long id,
                    @RequestBody @Valid PerformanceSessionRequestDto performanceSessionRequestDto) {
        PerformanceSession performanceSession = performanceSessionMapper
                .getEntity(performanceSessionRequestDto);
        performanceSession.setId(id);
        performanceSessionService.update(performanceSession);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        performanceSessionService.delete(id);
    }
}
