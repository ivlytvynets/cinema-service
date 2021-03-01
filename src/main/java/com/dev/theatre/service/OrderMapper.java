package com.dev.theatre.service;

import com.dev.theatre.model.Order;
import com.dev.theatre.model.dto.OrderResponseDto;

public interface OrderMapper {
    OrderResponseDto getResponseDto(Order order);
}
