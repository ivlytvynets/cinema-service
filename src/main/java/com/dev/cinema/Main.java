package com.dev.cinema;

import com.dev.cinema.exception.AuthenticationException;
import com.dev.cinema.lib.Injector;
import com.dev.cinema.model.CinemaHall;
import com.dev.cinema.model.Movie;
import com.dev.cinema.model.MovieSession;
import com.dev.cinema.model.User;
import com.dev.cinema.security.AuthenticationService;
import com.dev.cinema.service.CinemaHallService;
import com.dev.cinema.service.MovieService;
import com.dev.cinema.service.MovieSessionService;
import com.dev.cinema.service.ShoppingCartService;
import java.time.LocalDateTime;

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

        AuthenticationService authService = (AuthenticationService) injector
                .getInstance(AuthenticationService.class);
        authService.register("ivan@gmail.com", "ivan");
        authService.register("bohdan@gmail.com", "bohdan");
        authService.register("mash@gmail.com", "masha123");
        User ivan = null;
        User bohdan = null;
        User masha = null;
        try {
            ivan = authService.login("ivan@gmail.com", "ivan");
            bohdan = authService.login("bohdan@gmail.com", "bohdan");
            masha = authService.login("mash@gmail.com", "masha123");
        } catch (AuthenticationException e) {
            throw new RuntimeException("User can't login", e);
        }

        ShoppingCartService shoppingCartService = (ShoppingCartService) injector
                .getInstance(ShoppingCartService.class);
        shoppingCartService.addSession(movieSessionFirst, ivan);
        shoppingCartService.addSession(movieSessionSecond, ivan);
        shoppingCartService.addSession(movieSessionFirst, masha);
        shoppingCartService.addSession(movieSessionSecond, masha);
        shoppingCartService.addSession(movieSessionSecond, bohdan);
        System.out.println(shoppingCartService.getByUser(ivan));
        shoppingCartService.clear(shoppingCartService.getByUser(ivan));
        System.out.println(shoppingCartService.getByUser(masha));
        shoppingCartService.clear(shoppingCartService.getByUser(masha));
        System.out.println(shoppingCartService.getByUser(bohdan));
        shoppingCartService.clear(shoppingCartService.getByUser(bohdan));
        System.out.println(shoppingCartService.getByUser(ivan));
        System.out.println(shoppingCartService.getByUser(masha));
        System.out.println(shoppingCartService.getByUser(bohdan));
    }
}
