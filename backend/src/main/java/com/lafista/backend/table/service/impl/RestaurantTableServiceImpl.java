package com.lafista.backend.table.service.impl;

import com.lafista.backend.table.model.RestaurantTable;
import com.lafista.backend.table.repository.RestaurantTableRepository;
import com.lafista.backend.table.service.RestaurantTableService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantTableServiceImpl implements RestaurantTableService {
    private final RestaurantTableRepository tableRepository;

    public RestaurantTable getTableById(String tableId) {
        var table = tableRepository.findById(tableId);
        return table.orElseThrow(() -> new RuntimeException("Table Id Not Found"));
    }

    public List<RestaurantTable> getAllTables() {
        return tableRepository.findAll();
    }

    public RestaurantTable addTable(RestaurantTable table) {
        return tableRepository.save(table);
    }

    public void updateTable(String tableId, RestaurantTable newTable) {
        if (!tableRepository.existsById(tableId)) {
            throw new RuntimeException("Table Not Found");
        }

        newTable.setTableId(tableId);
        tableRepository.save(newTable);
    }

    public void deleteTable(String tableId) {
        tableRepository.deleteById(tableId);
    }

}
