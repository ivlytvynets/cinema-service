package com.dev.theatre.dao;

import com.dev.theatre.model.Ticket;
import java.util.Optional;

public interface TicketDao {
    Ticket add(Ticket ticket);

    Optional<Ticket> get(long id);
}
