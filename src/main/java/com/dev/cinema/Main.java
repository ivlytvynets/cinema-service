package com.dev.cinema;

import com.dev.cinema.lib.Injector;
import com.dev.cinema.model.CinemaHall;
import com.dev.cinema.model.Movie;
import com.dev.cinema.model.MovieSession;
import com.dev.cinema.service.CinemaHallService;
import com.dev.cinema.service.MovieService;
import com.dev.cinema.service.MovieSessionService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    private static Injector injector = Injector.getInstance("com.dev.cinema");

    public static void main(String[] args) {
        Movie fastAndFurious = new Movie();
        fastAndFurious.setTitle("Fast and Furious");
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        movieService.add(fastAndFurious);
        Movie onePlusOne = new Movie();
        onePlusOne.setTitle("1+1");
        movieService.add(onePlusOne);
        movieService.getAll().forEach(System.out::println);

        CinemaHall cinemaHallBig = new CinemaHall();
        cinemaHallBig.setCapacity(100);
        cinemaHallBig.setDescription("Big hall");

        CinemaHall cinemaHallSmall = new CinemaHall();
        cinemaHallSmall.setCapacity(50);
        cinemaHallSmall.setDescription("Small hall");

        CinemaHallService cinemaHallService = (CinemaHallService) injector
                .getInstance(CinemaHallService.class);
        cinemaHallService.add(cinemaHallBig);
        cinemaHallService.add(cinemaHallSmall);

        System.out.println(cinemaHallService.getAll());

        LocalDateTime localDateTime = LocalDateTime.of(2021, 1, 3, 10, 0);
        MovieSession movieSessionFirst = new MovieSession();
        movieSessionFirst.setMovie(fastAndFurious);
        movieSessionFirst.setCinemaHall(cinemaHallBig);
        movieSessionFirst.setShowTime(localDateTime);
        MovieSession movieSessionSecond = new MovieSession();
        movieSessionSecond.setMovie(onePlusOne);
        movieSessionSecond.setCinemaHall(cinemaHallSmall);
        movieSessionSecond.setShowTime(localDateTime);
        MovieSessionService movieSessionService = (MovieSessionService) injector
                .getInstance(MovieSessionService.class);
        movieSessionService.add(movieSessionFirst);
        movieSessionService.add(movieSessionSecond);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println(movieSessionService.findAvailableSessions(1L,
                LocalDate.parse(dateTimeFormatter.format(localDateTime))));
    }
}
