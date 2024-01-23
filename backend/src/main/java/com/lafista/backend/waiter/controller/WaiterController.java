package com.lafista.backend.waiter.controller;

import com.lafista.backend.waiter.dto.WaiterDTO;
import com.lafista.backend.waiter.model.Waiter;
import com.lafista.backend.waiter.service.impl.WaiterServiceImpl;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/waiter")
public class WaiterController {
    private final WaiterServiceImpl waiterService;

    @GetMapping
    public List<Waiter> getAllWaiters() {
        return waiterService.getAllWaiters();
    }

    @GetMapping("/{waiterId}")
    public Waiter getWaiterId(@PathVariable String waiterId) {
        return waiterService.getWaiterById(waiterId);
    }

    @GetMapping("/assigned-table/{tableId}")
    public void getWaiterAssignedToRestaurantTable(@PathVariable String tableId) {
        waiterService.getWaiterAssignedToTable(tableId);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addWaiter(@RequestBody WaiterDTO waiterDTO) {
        var waiter = new Waiter();
        BeanUtils.copyProperties(waiterDTO, waiter);
        waiterService.addWaiter(waiter);
    }

    @PostMapping("/assign-table")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void assignTableToWaiter(@RequestParam String waiterId, @RequestParam String tableId) {
        waiterService.assignTableToWaiter(waiterId, tableId);
    }

    @PutMapping("/{waiterId}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void updateWaiter(@PathVariable String waiterId, @RequestBody WaiterDTO waiterDTO) {
        var waiter = new Waiter();
        BeanUtils.copyProperties(waiterDTO, waiter);
        waiterService.updateWaiter(waiterId, waiter);
    }

    @DeleteMapping("/{waiterId}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteWaiter(@PathVariable String waiterId) {
        waiterService.deleteWaiter(waiterId);
    }
}
