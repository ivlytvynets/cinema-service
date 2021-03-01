package com.dev.theatre.service.impl;

import com.dev.theatre.model.ShoppingCart;
import com.dev.theatre.model.Ticket;
import com.dev.theatre.model.dto.ShoppingCartResponseDto;
import com.dev.theatre.service.ShoppingCartMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapperImpl implements ShoppingCartMapper {
    @Override
    public ShoppingCartResponseDto getResponseDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        shoppingCartResponseDto.setId(shoppingCart.getId());
        List<Long> ticketIds = new ArrayList<>();
        for (Ticket ticket : shoppingCart.getTickets()) {
            ticketIds.add(ticket.getId());
        }
        shoppingCartResponseDto.setTicketIds(ticketIds);
        shoppingCartResponseDto.setUserId(shoppingCart.getUser().getId());
        return shoppingCartResponseDto;
    }
}
