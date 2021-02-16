package com.dev.cinema.service.impl;

import com.dev.cinema.dao.TicketDao;
import com.dev.cinema.model.Ticket;
import com.dev.cinema.service.TicketService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketDao ticketDao;

    public TicketServiceImpl(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Override
    public Optional<Ticket> get(Long id) {
        return ticketDao.get(id);
    }
}
