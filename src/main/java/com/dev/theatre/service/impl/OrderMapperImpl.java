package com.dev.theatre.service.impl;

import com.dev.theatre.model.Order;
import com.dev.theatre.model.Ticket;
import com.dev.theatre.model.dto.OrderResponseDto;
import com.dev.theatre.service.OrderMapper;
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
