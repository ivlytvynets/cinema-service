package com.dev.cinema.dao;

import com.dev.cinema.model.Ticket;
import java.util.Optional;

public interface TicketDao {
    Ticket add(Ticket ticket);

    Optional<Ticket> get(long id);
}
