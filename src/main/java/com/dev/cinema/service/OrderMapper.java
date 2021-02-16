package com.dev.cinema.service;

import com.dev.cinema.model.Order;
import com.dev.cinema.model.dto.OrderResponseDto;

public interface OrderMapper {
    OrderResponseDto getResponseDto(Order order);
}
