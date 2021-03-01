package com.dev.theatre.service;

import com.dev.theatre.model.PerformanceSession;
import java.time.LocalDate;
import java.util.List;

public interface PerformanceSessionService {
    List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date);

    PerformanceSession add(PerformanceSession session);

    PerformanceSession update(PerformanceSession performanceSession);

    PerformanceSession get(Long id);

    void delete(Long id);
}
