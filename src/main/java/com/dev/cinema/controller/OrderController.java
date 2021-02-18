package com.dev.cinema.controller;

import com.dev.cinema.model.Order;
import com.dev.cinema.model.User;
import com.dev.cinema.model.dto.OrderResponseDto;
import com.dev.cinema.service.OrderMapper;
import com.dev.cinema.service.OrderService;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderMapper orderMapper;
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public OrderController(OrderMapper orderMapper, OrderService orderService,
                           ShoppingCartService shoppingCartService, UserService userService) {
        this.orderMapper = orderMapper;
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @PostMapping("/complete")
    public void complete(Authentication authentication) {
        User user = userService.findByEmail(authentication.getName()).get();
        orderService.completeOrder(shoppingCartService.getByUser(userService.get(user.getId())));
    }

    @GetMapping
    public List<OrderResponseDto> get(Authentication authentication) {
        User user = userService.findByEmail(authentication.getName()).get();
        List<Order> orders = orderService.getOrdersHistory(userService.get(user.getId()));
        return orders
                .stream()
                .map(orderMapper::getResponseDto)
                .collect(Collectors.toList());
    }
}
