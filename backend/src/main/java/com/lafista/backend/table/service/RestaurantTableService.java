package com.lafista.backend.table.service;

import java.util.List;

import com.lafista.backend.table.model.RestaurantTable;

public interface RestaurantTableService {
    public RestaurantTable addTable(RestaurantTable table);

    public void deleteTable(String tableId);

    public List<RestaurantTable> getAllTables();

    public RestaurantTable getTableById(String tableId);
}
