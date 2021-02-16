package com.dev.cinema.model.dto;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketIds;
    private Long userId;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
