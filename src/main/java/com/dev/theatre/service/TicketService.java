package com.dev.theatre.service;

import com.dev.theatre.model.Ticket;
import java.util.Optional;

public interface TicketService {
    Optional<Ticket> get(Long id);
}
