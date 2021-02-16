package com.dev.cinema.service;

import com.dev.cinema.model.ShoppingCart;
import com.dev.cinema.model.dto.ShoppingCartResponseDto;

public interface ShoppingCartMapper {
    ShoppingCartResponseDto getResponseDto(ShoppingCart shoppingCart);
}
