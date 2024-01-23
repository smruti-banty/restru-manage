package com.lafista.backend.table.controller;

import com.lafista.backend.table.dto.RestaurantTableDTO;
import com.lafista.backend.table.model.RestaurantTable;
import com.lafista.backend.table.service.impl.RestaurantTableServiceImpl;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/table")
public class RestaurantTableController {
    private final RestaurantTableServiceImpl tableService;

    @GetMapping
    public List<RestaurantTable> getAllTables() {
        return tableService.getAllTables();
    }

    @GetMapping("/{tableId}")
    public RestaurantTable getTableById(@PathVariable String tableId) {
        return tableService.getTableById(tableId);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addTable(@RequestBody RestaurantTableDTO tableDTO) {
        var table = new RestaurantTable();
        BeanUtils.copyProperties(tableDTO, table);
        tableService.addTable(table);
    }

    @PutMapping("/{tableId}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void updateTable(@PathVariable String tableId, @RequestBody RestaurantTableDTO tableDTO) {
        var table = new RestaurantTable();
        BeanUtils.copyProperties(tableDTO, table);
        tableService.updateTable(tableId, table);
    }

    @DeleteMapping("/{tableId}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteTable(@PathVariable String tableId) {
        tableService.deleteTable(tableId);
    }
}