package com.dev.theatre.model.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponseDto {
    private Long id;
    private List<Long> ticketIds;
    private LocalDateTime orderTime;
    private String userEmail;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
