package com.dev.cinema.controller;

import com.dev.cinema.model.MovieSession;
import com.dev.cinema.model.ShoppingCart;
import com.dev.cinema.model.User;
import com.dev.cinema.model.dto.ShoppingCartResponseDto;
import com.dev.cinema.service.MovieSessionService;
import com.dev.cinema.service.ShoppingCartMapper;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final MovieSessionService movieSessionService;
    private final UserService userService;
    private final ShoppingCartMapper shoppingCartMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  MovieSessionService movieSessionService,
                                  UserService userService,
                                  ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartService = shoppingCartService;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @PostMapping("/movie-sessions")
    public void addMovieSession(@RequestParam Long userId, @RequestParam Long movieSessionId) {
        MovieSession movieSession = movieSessionService.get(movieSessionId);
        User user = userService.get(userId);
        shoppingCartService.addSession(movieSession, user);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        ShoppingCart shoppingCart = shoppingCartService
                .getByUser(userService.get(userId));
        return shoppingCartMapper.getResponseDto(shoppingCart);
    }
}