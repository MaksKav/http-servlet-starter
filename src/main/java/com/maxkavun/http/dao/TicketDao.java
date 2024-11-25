package com.maxkavun.http.dao;

import com.maxkavun.http.entity.Ticket;

import java.util.List;
import java.util.Optional;

public class TicketDao implements Dao<Long , Ticket> {

    private TicketDao() {
    }

    private static final TicketDao INSTANCE = new TicketDao();

    public static TicketDao getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Ticket> findAll() {
        return List.of();
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Ticket entity) {

    }

    @Override
    public Ticket save(Ticket entity) {
        return null;
    }
}
