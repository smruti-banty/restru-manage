package com.lafista.backend.waiter.controller;

import com.lafista.backend.waiter.model.Waiter;
import com.lafista.backend.waiter.service.impl.WaiterServiceImpl;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/waiters")
public class WaiterController {
    private final WaiterServiceImpl waiterService;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Waiter> getAllWaiters() {
        return waiterService.getAllWaiters();
    }

    @GetMapping("/assigned-table/{tableId}")
    @ResponseStatus(code = HttpStatus.OK)
    public void getWaiterAssignedToRestaurantTable(@PathVariable String tableId) {
        waiterService.getWaiterAssignedToTable(tableId);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void addWaiter(@RequestBody Waiter waiter) {
        waiterService.addWaiter(waiter);
    }

    @PostMapping("/assign-table")
    @ResponseStatus(code = HttpStatus.OK)
    public void assignTableToWaiter(@RequestParam String waiterId, @RequestParam String tableId) {
        waiterService.assignTableToWaiter(waiterId, tableId);
    }

    @DeleteMapping("/{waiterId}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteWaiter(@PathVariable String waiterId) {
        waiterService.deleteWaiter(waiterId);
    }
}
