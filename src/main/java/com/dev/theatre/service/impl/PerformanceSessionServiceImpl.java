package com.dev.theatre.service.impl;

import com.dev.theatre.dao.PerformanceSessionDao;
import com.dev.theatre.exception.DataProcessingException;
import com.dev.theatre.model.PerformanceSession;
import com.dev.theatre.service.PerformanceSessionService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PerformanceSessionServiceImpl implements PerformanceSessionService {
    private final PerformanceSessionDao performanceSessionDao;

    public PerformanceSessionServiceImpl(PerformanceSessionDao performanceSessionDao) {
        this.performanceSessionDao = performanceSessionDao;
    }

    @Override
    public List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date) {
        return performanceSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public PerformanceSession add(PerformanceSession performanceSession) {
        return performanceSessionDao.add(performanceSession);
    }

    @Override
    public PerformanceSession update(PerformanceSession performanceSession) {
        return performanceSessionDao.update(performanceSession);
    }

    @Override
    public PerformanceSession get(Long id) {
        return performanceSessionDao.get(id).orElseThrow(() ->
                new DataProcessingException("Can't get performance session with id: " + id));
    }

    @Override
    public void delete(Long id) {
        performanceSessionDao.delete(id);
    }
}
