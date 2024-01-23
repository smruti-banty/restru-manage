package com.lafista.backend.waiter.service;

import java.util.List;

import com.lafista.backend.waiter.model.Waiter;

public interface WaiterService {
    public Waiter getWaiterById(String waiterId);

    public List<Waiter> getAllWaiters();

    public Waiter getWaiterAssignedToTable(String tableId);

    public Waiter addWaiter(Waiter waiter);

    public Waiter assignTableToWaiter(String waiterId, String tableId);

    public void updateWaiter(String waiterId, Waiter waiter);

    public void deleteWaiter(String waiterId);
}
