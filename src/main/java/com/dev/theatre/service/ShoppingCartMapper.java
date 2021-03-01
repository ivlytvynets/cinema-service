package com.dev.theatre.service;

import com.dev.theatre.model.ShoppingCart;
import com.dev.theatre.model.dto.ShoppingCartResponseDto;

public interface ShoppingCartMapper {
    ShoppingCartResponseDto getResponseDto(ShoppingCart shoppingCart);
}
