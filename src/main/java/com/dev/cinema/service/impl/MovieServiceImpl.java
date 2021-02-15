package com.dev.cinema.service.impl;

import com.dev.cinema.dao.MovieDao;
import com.dev.cinema.exception.DataProcessingException;
import com.dev.cinema.model.Movie;
import com.dev.cinema.service.MovieService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }

    @Override
    public Movie get(Long id) {
        return movieDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get movie with id: " + id));
    }
}
