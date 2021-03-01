package com.dev.theatre.service.impl;

import com.dev.theatre.dao.TicketDao;
import com.dev.theatre.model.Ticket;
import com.dev.theatre.service.TicketService;
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
