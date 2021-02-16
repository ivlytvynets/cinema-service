package com.dev.cinema.service;

import com.dev.cinema.model.Ticket;
import java.util.Optional;

public interface TicketService {
    Optional<Ticket> get(Long id);
}
