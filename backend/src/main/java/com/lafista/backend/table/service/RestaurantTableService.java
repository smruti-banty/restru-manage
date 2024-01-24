package com.lafista.backend.table.service;

import java.util.List;

import com.lafista.backend.table.model.RestaurantTable;

public interface RestaurantTableService {
    public RestaurantTable getTableById(String tableId);

    public List<RestaurantTable> getAllTables();

    public RestaurantTable addTable(RestaurantTable table);

    public void updateTable(String tableId, RestaurantTable table);

    public void deleteTable(String tableId);
}
