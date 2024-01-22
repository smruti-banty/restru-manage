package com.lafista.backend.waiter.service;

import java.util.List;

import com.lafista.backend.waiter.model.Waiter;

public interface WaiterService {
    public Waiter addWaiter(Waiter waiter);

    public void deleteWaiter(String waiterId);

    public List<Waiter> getAllWaiters();

    public Waiter getWaiterById(String waiterId);

    public Waiter getWaiterAssignedToTable(String tableId);

    public Waiter assignTableToWaiter(String waiterId, String tableId);
}
