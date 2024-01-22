package com.lafista.backend.table.controller;

import com.lafista.backend.table.model.RestaurantTable;
import com.lafista.backend.table.service.impl.RestaurantTableServiceImpl;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tables")
public class RestaurantTableController {
    private final RestaurantTableServiceImpl tableService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void addTable(@RequestBody RestaurantTable table) {
        tableService.addTable(table);
    }

    @DeleteMapping("/{tableId}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteTable(@PathVariable String tableId) {
        tableService.deleteTable(tableId);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<RestaurantTable> getAllTables() {
        return tableService.getAllTables();
    }
}
