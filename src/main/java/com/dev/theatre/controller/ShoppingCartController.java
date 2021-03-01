package com.dev.theatre.controller;

import com.dev.theatre.model.PerformanceSession;
import com.dev.theatre.model.ShoppingCart;
import com.dev.theatre.model.User;
import com.dev.theatre.model.dto.ShoppingCartResponseDto;
import com.dev.theatre.service.PerformanceSessionService;
import com.dev.theatre.service.ShoppingCartMapper;
import com.dev.theatre.service.ShoppingCartService;
import com.dev.theatre.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final PerformanceSessionService performanceSessionService;
    private final UserService userService;
    private final ShoppingCartMapper shoppingCartMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  PerformanceSessionService performanceSessionService,
                                  UserService userService,
                                  ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartService = shoppingCartService;
        this.performanceSessionService = performanceSessionService;
        this.userService = userService;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @PostMapping("/performance-sessions")
    public void addMovieSession(Authentication authentication,
                                @RequestParam Long performanceSessionId) {
        PerformanceSession performanceSession = performanceSessionService
                .get(performanceSessionId);
        User user = userService.findByEmail(authentication.getName()).get();
        shoppingCartService.addSession(performanceSession, user);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication authentication) {
        ShoppingCart shoppingCart = shoppingCartService
                .getByUser(userService.findByEmail(authentication.getName()).get());
        return shoppingCartMapper.getResponseDto(shoppingCart);
    }
}
