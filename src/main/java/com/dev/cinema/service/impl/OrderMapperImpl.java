package com.dev.cinema.service.impl;

import com.dev.cinema.model.Order;
import com.dev.cinema.model.Ticket;
import com.dev.cinema.model.dto.OrderResponseDto;
import com.dev.cinema.service.OrderMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperImpl implements OrderMapper {
    @Override
    public OrderResponseDto getResponseDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        List<Long> ticketIds = new ArrayList<>();
        for (Ticket ticket : order.getTickets()) {
            ticketIds.add(ticket.getId());
        }
        orderResponseDto.setTicketIds(ticketIds);
        orderResponseDto.setOrderTime(order.getOrderDate());
        orderResponseDto.setUserEmail(order.getUser().getEmail());
        return orderResponseDto;
    }
}
