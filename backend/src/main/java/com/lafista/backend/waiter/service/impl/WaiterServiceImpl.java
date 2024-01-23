package com.lafista.backend.waiter.service.impl;

import com.lafista.backend.table.service.impl.RestaurantTableServiceImpl;
import com.lafista.backend.waiter.dto.WaiterDTO;
import com.lafista.backend.waiter.model.Waiter;
import com.lafista.backend.waiter.repository.WaiterRepository;
import com.lafista.backend.waiter.service.WaiterService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WaiterServiceImpl implements WaiterService {
    private final RestaurantTableServiceImpl tableService;
    private final WaiterRepository waiterRepository;

    public Waiter getWaiterById(String waiterId) {
        return waiterRepository.findById(waiterId).orElseThrow(() -> new RuntimeException("Waiter Id Not Found"));
    }

    public List<Waiter> getAllWaiters() {
        return waiterRepository.findAll();
    }

    public Waiter getWaiterAssignedToTable(String tableId) {
        var assignedTable = tableService.getTableById(tableId);
        return assignedTable.getAssignedWaiter();
    }

    public Waiter addWaiter(Waiter waiter) {
        return waiterRepository.save(waiter);
    }

    public Waiter assignTableToWaiter(String waiterId, String tableId) {
        var waiter = getWaiterById(waiterId);
        var table = tableService.getTableById(tableId);

        waiter.setAssignedTable(table);
        return waiterRepository.save(waiter);
    }

    public void updateWaiter(String waiterId, Waiter waiter) {
        if (!waiterRepository.existsById(waiterId)) {
            new RuntimeException("Waiter Not Found");
        }

        waiter.setWaiterId(waiterId);
        waiterRepository.save(waiter);
    }

    public void deleteWaiter(String waiterId) {
        waiterRepository.deleteById(waiterId);
    }
}
