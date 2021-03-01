package com.dev.theatre.dao;

import com.dev.theatre.model.PerformanceSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PerformanceSessionDao {
    List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date);

    PerformanceSession add(PerformanceSession session);

    PerformanceSession update(PerformanceSession performanceSession);

    Optional<PerformanceSession> get(Long id);

    void delete(Long id);
}
